package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Usuario;



@Local
public interface UsuarioFacade {

	public abstract void save(Usuario Usuario);

	public abstract Usuario update(Usuario Usuario);
	
	public abstract void delete(Usuario Usuario);

	public abstract Usuario find(int entityID);
	
	public abstract List<Usuario> findAll();
	
	public abstract List<Usuario> listarPorEmail(String email);
	
	public abstract List<Usuario> listarPorLogin(String login);
	
}
