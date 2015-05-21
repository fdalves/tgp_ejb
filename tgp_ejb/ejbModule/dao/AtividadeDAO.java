package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.Atividade;
import model.UsuarioAtividade;



@Stateless
public class AtividadeDAO extends GenericDAO<Atividade> {
	
	public AtividadeDAO() {
		super(Atividade.class);
	}
	
	

	public List<Atividade> listarPorProjeto(int projetoId){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("projetoId",projetoId);     
	    return super.findListResult(Atividade.FIND_BY_PROJETO,parameters);
	}
}