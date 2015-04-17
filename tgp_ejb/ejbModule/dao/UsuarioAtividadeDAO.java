package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.UsuarioAtividade;



@Stateless
public class UsuarioAtividadeDAO extends GenericDAO<UsuarioAtividade> {
	
	public UsuarioAtividadeDAO() {
		super(UsuarioAtividade.class);
	}
	
	
	public List<UsuarioAtividade> listarPorAtividade(int atividadeId){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("atividadeId",atividadeId);     
	    return super.findListResult(UsuarioAtividade.FIND_BY_ATIVIDADE,parameters);
	}
	 
}