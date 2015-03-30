package dao;

import javax.ejb.Stateless;

import model.Atividade;



@Stateless
public class AtividadeDAO extends GenericDAO<Atividade> {
	
	public AtividadeDAO() {
		super(Atividade.class);
	}
	
	 
}