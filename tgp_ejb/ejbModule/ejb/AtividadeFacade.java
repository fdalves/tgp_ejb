package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Atividade;



@Local
public interface AtividadeFacade {

	public abstract void save(Atividade atividade);

	public abstract Atividade update(Atividade atividade);
	
	public abstract void delete(Atividade atividade);

	public abstract Atividade find(int entityID);
	
	public abstract List<Atividade> findAll();
	
	public abstract String savarAtividade(Atividade atividade);
	
	
	
}
