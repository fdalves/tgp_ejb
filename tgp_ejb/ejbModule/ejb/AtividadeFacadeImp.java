package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.Atividade;
import model.Cargo;
import model.ConfigAtividade;
import model.DocAtividade;
import model.Usuario;
import model.UsuarioAtividade;
import dao.AtividadeDAO;
import dao.CargoDAO;
import dao.ConfigAtividadeDAO;
import dao.DocAtividadeDAO;
import dao.ProjetoDAO;
import dao.UsuarioAtividadeDAO;
import dao.UsuarioDAO;



/**
 * Session Bean implementation class AtividadeFacadeImp
 */
@Stateless
  public class AtividadeFacadeImp implements AtividadeFacade {

    @EJB
    private AtividadeDAO dao;
    @EJB
   	private UsuarioAtividadeDAO usuarioAtividadeDAO;
    @EJB
    private ConfigAtividadeDAO configAtividadeDAO;
    @EJB
    private CargoDAO cargoDAO;
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private DocAtividadeDAO docAtividadeDAO;
    @EJB
    private ProjetoDAO projetoDAO;
    
    
    public AtividadeFacadeImp() {
    	
    }

	@Override
	public void save(Atividade atividade) {
		dao.save(atividade);		
		
	}

	@Override
	public Atividade update(Atividade atividade) {		
		return dao.update(atividade);
	}

	@Override
	public void delete(Atividade atividade) {
		dao.delete(atividade);
	}

	@Override
	public Atividade find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<Atividade> findAll() {
		
		return dao.findAll();
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String savarAtividade(Atividade atividade) {
		String msg = null;
		try {
			Usuario usuario = this.usuarioDAO.find(atividade.getGerente().getUsuarioId());
			atividade.setGerente(usuario);
			
			List<DocAtividade> list = atividade.getDocAtividades();
			if (list!=null && !list.isEmpty()){
				for (DocAtividade docAtividade : list) {
					 docAtividade.setAtividade(atividade);
					 docAtividadeDAO.save(docAtividade);
				}
			}
			
			this.dao.save(atividade);
			atividade = dao.find(atividade.getAtividadeId());
			ConfigAtividade configAtividade = atividade.getConfigAtividade();
			configAtividade.setAtividade(atividade);
			configAtividadeDAO.save(configAtividade);
			atividade.setConfigAtividade(configAtividade);
			List<UsuarioAtividade> usuarioAtividades = atividade.getUsuarioAtividades();
			
			for (UsuarioAtividade usuarioAtividade : usuarioAtividades) {
				usuarioAtividade.setAtividade(atividade);
				Cargo cargo = usuarioAtividade.getCargo();
				if (cargo != null){
					cargoDAO.save(cargo);
					cargo = cargoDAO.find(cargo.getCargoId());
				}
				usuarioAtividade.setCargo(cargo);
				usuarioAtividadeDAO.save(usuarioAtividade);
				usuarioAtividade = usuarioAtividadeDAO.find(usuarioAtividade.getUsuarioAtividadeId());
				cargo.setUsuarioAtividade(usuarioAtividade);
				usuarioAtividade.setCargo(cargo);
				usuarioAtividadeDAO.update(usuarioAtividade);
				cargoDAO.update(cargo);
			}
			
			atividade = dao.find(atividade.getAtividadeId());
			dao.update(atividade);
			
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return msg;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public String atualizaAtividade(Atividade oldAtiv, Atividade newAtiv, List<UsuarioAtividade> lsiusuAtiviOld,List<UsuarioAtividade> lsiusuAtiviNew){
		String msg = null;
		
		try {
			
			this.addUsuarioAtividade(lsiusuAtiviOld, lsiusuAtiviNew, newAtiv);
			oldAtiv.getConfigAtividade().setQuantDiasFolgaFeriado(newAtiv.getConfigAtividade().getQuantDiasFolgaFeriado());
			oldAtiv.getConfigAtividade().setQuantHorasDias(newAtiv.getConfigAtividade().getQuantHorasDias());
			oldAtiv.getConfigAtividade().setTrabDom(newAtiv.getConfigAtividade().isTrabDom());
			oldAtiv.getConfigAtividade().setTrabSab(newAtiv.getConfigAtividade().isTrabSab());
			
			oldAtiv.setConfigAtividade(configAtividadeDAO.update(oldAtiv.getConfigAtividade()));
			
			
			oldAtiv.setAtividadeNome(newAtiv.getAtividadeNome());
			oldAtiv.setDescAtividade(newAtiv.getDescAtividade());
			oldAtiv.setDtIni(newAtiv.getDtIni());
			oldAtiv.setDtFim(newAtiv.getDtFim());
			oldAtiv.setDivideReplicaTempo(newAtiv.getDivideReplicaTempo());
			oldAtiv.setPrioridade(newAtiv.getPrioridade());
			oldAtiv.setGerente(newAtiv.getGerente());
			oldAtiv.setProjeto(newAtiv.getProjeto());
			dao.update(oldAtiv);
			
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return msg;
	}

	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private void addUsuarioAtividade(List<UsuarioAtividade> lsiusuAtiviOld,List<UsuarioAtividade> lsiusuAtiviNew, Atividade newAtiv){
		for (UsuarioAtividade usuarioAtividadeNew : lsiusuAtiviNew) {
			if(usuarioAtividadeNew.getUsuarioAtividadeId() == 0){
				usuarioAtividadeNew.setAtividade(newAtiv);
				Cargo c = usuarioAtividadeNew.getCargo();
				this.cargoDAO.save(c);
				usuarioAtividadeNew.setCargo(c);
				this.usuarioAtividadeDAO.save(usuarioAtividadeNew);
			}
		}
	}
	
	@Override
	public List<UsuarioAtividade> findUsuarioAtividade(int atividadeId) {
		return usuarioAtividadeDAO.listarPorAtividade(atividadeId);
	}

	@Override
	public List<DocAtividade> findDocAtividade(int atividadeId) {
		return docAtividadeDAO.listarPorAtividade(atividadeId);
	}

	

	

	
	
}
