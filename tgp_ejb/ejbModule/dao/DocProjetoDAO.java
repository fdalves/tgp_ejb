package dao;

import javax.ejb.Stateless;

import model.DocProjeto;



@Stateless
public class DocProjetoDAO extends GenericDAO<DocProjeto> {
	
	public DocProjetoDAO() {
		super(DocProjeto.class);
	}
	
	 
}