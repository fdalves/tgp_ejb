package dao;

import javax.ejb.Stateless;

import model.Usuario;



@Stateless
public class UsuarioDAO extends GenericDAO<Usuario> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	
	 
}