package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.Usuario;



@Stateless
public class UsuarioDAO extends GenericDAO<Usuario> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public List<Usuario> listarPorLogin(String login){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("login",login);     
	    return super.findListResult(Usuario.FIND_BY_LOGIN,parameters);
	}
	
	public List<Usuario> listarPoreEmail(String email){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("email",email);     
	    return super.findListResult(Usuario.FIND_BY_EMAIL,parameters);
	}
	 
}