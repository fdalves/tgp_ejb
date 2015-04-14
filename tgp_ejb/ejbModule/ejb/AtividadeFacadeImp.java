package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.Atividade;
import model.Usuario;
import dao.AtividadeDAO;
import dao.UsuarioDAO;



/**
 * Session Bean implementation class AtividadeFacadeImp
 */
@Stateless
  public class AtividadeFacadeImp implements AtividadeFacade {

    @EJB
    private AtividadeDAO dao;
    
   @EJB
   private UsuarioDAO usuarioDAO;
   
    
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
	public void saveTeste() {
		try {
			Atividade atividade = new Atividade();
			
			atividade.setDescAtividade(".........");
			
			Usuario usuario = new Usuario();
			usuario.setUsuarioId(25);
			usuario.setNome("..........");
			
			dao.save(atividade);
			usuarioDAO.save(usuario);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	

	
	
}
