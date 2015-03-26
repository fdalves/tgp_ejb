package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Projeto;



@Local
public interface ProjetoFacade {

	public abstract void save(Projeto projeto);

	public abstract Projeto update(Projeto projeto);
	
	public abstract void delete(Projeto projeto);

	public abstract Projeto find(int entityID);
	
	public abstract List<Projeto> findAll();
	
	public abstract List<Projeto> listarPorNomeProjeto(String nomeProjeto);
	
	public abstract List<Projeto> listarPorSiglaProjeto(String siglaProjeto);
	
	
	
}
