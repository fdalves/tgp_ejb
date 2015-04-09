package ejb;

import java.util.List;

import javax.ejb.Local;

import model.ConfigAtividade;



@Local
public interface ConfigAtividadeFacade {

	public abstract void save(ConfigAtividade confAtividade);

	public abstract ConfigAtividade update(ConfigAtividade confAtividade);
	
	public abstract void delete(ConfigAtividade confAtividade);

	public abstract ConfigAtividade find(int entityID);
	
	public abstract List<ConfigAtividade> findAll();
	
	
	
	
	
}
