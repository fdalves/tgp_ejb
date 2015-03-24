package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.Projeto;



@Stateless
public class ProjetoDAO extends GenericDAO<Projeto> {
	
	public ProjetoDAO() {
		super(Projeto.class);
	}
	
	public List<Projeto> listarPorNomeProjeto(String nomeProjeto){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("nomeProjeto",nomeProjeto);     
	    return super.findListResult(Projeto.FIND_BY_NOME,parameters);
	}
	
	public List<Projeto> listarPorSiglaProjeto(String siglaProjeto){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("siglaProjeto",siglaProjeto);     
	    return super.findListResult(Projeto.FIND_BY_SIGLA,parameters);
	}
	 
}