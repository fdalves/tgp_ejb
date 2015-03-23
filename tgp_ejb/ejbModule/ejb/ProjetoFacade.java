package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Projeto;



@Local
public interface ProjetoFacade {

	public abstract void save(Projeto Projeto);

	public abstract Projeto update(Projeto Projeto);
	
	public abstract void delete(Projeto Projeto);

	public abstract Projeto find(int entityID);
	
	public abstract List<Projeto> findAll();
	
	
	
}
