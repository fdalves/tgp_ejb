package dao;

import javax.ejb.Stateless;

import model.DocAtividade;



@Stateless
public class DocAtividadeDAO extends GenericDAO<DocAtividade> {
	
	public DocAtividadeDAO() {
		super(DocAtividade.class);
	}
	
	 
}