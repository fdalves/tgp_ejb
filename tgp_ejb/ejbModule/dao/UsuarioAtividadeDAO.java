package dao;

import javax.ejb.Stateless;

import model.UsuarioAtividade;



@Stateless
public class UsuarioAtividadeDAO extends GenericDAO<UsuarioAtividade> {
	
	public UsuarioAtividadeDAO() {
		super(UsuarioAtividade.class);
	}
	
	 
}