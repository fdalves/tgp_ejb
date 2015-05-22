package ejb;

import java.util.List;

import javax.ejb.Local;

import model.UsuarioAtividade;



@Local
public interface UsuarioAtividadeFacade {

	public abstract void save(UsuarioAtividade u);

	public abstract UsuarioAtividade update(UsuarioAtividade u);
	
	public abstract void delete(UsuarioAtividade u);

	public abstract UsuarioAtividade find(int entityID);
	
	public abstract List<UsuarioAtividade> findAll();
	
	
}
