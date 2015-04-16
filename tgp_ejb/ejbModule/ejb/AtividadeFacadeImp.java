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
			atividade = dao.find(atividade.getAitividadeId());
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
			
			atividade = dao.find(atividade.getAitividadeId());
			dao.update(atividade);
			
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return msg;
	}

	

	

	
	
}
