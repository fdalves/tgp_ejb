package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Usuario;
import dao.UsuarioDAO;



/**
 * Session Bean implementation class UsuarioFacadeImp
 */
@Stateless
public class UsuarioFacadeImp implements UsuarioFacade {

    @EJB
    private UsuarioDAO dao;
    
   
   
    
    public UsuarioFacadeImp() {
    	
    }

	@Override
	public void save(Usuario Usuario) {
		dao.save(Usuario);		
		
	}

	@Override
	public Usuario update(Usuario recurso) {		
		return dao.update(recurso);
	}

	@Override
	public void delete(Usuario recurso) {
		dao.delete(recurso);
	}

	@Override
	public Usuario find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<Usuario> findAll() {
		
		return dao.findAll();
	}

	

	

	
	
}
