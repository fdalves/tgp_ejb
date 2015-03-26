package ejb;

import java.util.List;

import javax.ejb.Local;

import model.DocProjeto;



@Local
public interface DocProjetoFacade {

	public abstract void save(DocProjeto docProjeto);

	public abstract DocProjeto update(DocProjeto docProjeto);
	
	public abstract void delete(DocProjeto docProjeto);

	public abstract DocProjeto find(int entityID);
	
	public abstract List<DocProjeto> findAll();
	
	
	
	
	
}
