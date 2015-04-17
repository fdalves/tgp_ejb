package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.DocAtividade;



@Stateless
public class DocAtividadeDAO extends GenericDAO<DocAtividade> {
	
	public DocAtividadeDAO() {
		super(DocAtividade.class);
	}
	
	public List<DocAtividade> listarPorAtividade(int atividadeId){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("atividadeId",atividadeId);     
	    return super.findListResult(DocAtividade.FIND_BY_ATIVIDADE,parameters);
	} 
	
}