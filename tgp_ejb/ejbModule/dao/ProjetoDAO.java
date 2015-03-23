package dao;

import javax.ejb.Stateless;

import model.Projeto;



@Stateless
public class ProjetoDAO extends GenericDAO<Projeto> {
	
	public ProjetoDAO() {
		super(Projeto.class);
	}
	
	
	 
}