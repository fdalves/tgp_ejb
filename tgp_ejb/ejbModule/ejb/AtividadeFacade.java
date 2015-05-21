package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Atividade;
import model.DocAtividade;
import model.UsuarioAtividade;



@Local
public interface AtividadeFacade {

	public abstract void save(Atividade atividade);

	public abstract Atividade update(Atividade atividade);
	
	public abstract void delete(Atividade atividade);

	public abstract Atividade find(int entityID);
	
	public abstract List<Atividade> findAll();
	
	public abstract String savarAtividade(Atividade atividade);
	
	public abstract List<UsuarioAtividade> findUsuarioAtividade(int atividadeId);
	
	public abstract List<DocAtividade> findDocAtividade(int atividadeId);
	
	
	public abstract String atualizaAtividade(Atividade oldAtiv, Atividade newAtiv,
										List<UsuarioAtividade> listOld, List<UsuarioAtividade> listNew,
										List<DocAtividade> listDocOld,List<DocAtividade> listDocNew);
	
	public abstract List<UsuarioAtividade> findAtividadeByUsuario(int atividadeId);
	
	public abstract List<Atividade> findAtividadeByProjeto(int projetoId);
	
	
}
