package ejb;

import java.util.List;

import javax.ejb.Local;

import model.DocAtividade;



@Local
public interface DocAtividadeFacade {

	public abstract void save(DocAtividade e);

	public abstract DocAtividade update(DocAtividade e);
	
	public abstract void delete(DocAtividade e);

	public abstract DocAtividade find(int entityID);
	
	public abstract List<DocAtividade> findAll();
	
	
	
	
	
}
