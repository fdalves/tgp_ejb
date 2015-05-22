package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.UsuarioAtividade;
import dao.UsuarioAtividadeDAO;




@Stateless
public class UsuarioAtividadeFacadeImp implements UsuarioAtividadeFacade {

    @EJB
    private UsuarioAtividadeDAO dao;
    
   
   
    
    public UsuarioAtividadeFacadeImp() {
    	
    }

	@Override
	public void save(UsuarioAtividade u) {
		dao.save(u);		
		
	}

	@Override
	public UsuarioAtividade update(UsuarioAtividade u) {		
		return dao.update(u);
	}

	@Override
	public void delete(UsuarioAtividade u) {
		dao.delete(u);
	}

	@Override
	public UsuarioAtividade find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<UsuarioAtividade> findAll() {
		
		return dao.findAll();
	}

	

	

	

	
	
}
