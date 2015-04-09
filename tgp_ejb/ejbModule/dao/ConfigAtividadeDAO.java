package dao;

import javax.ejb.Stateless;

import model.ConfigAtividade;



@Stateless
public class ConfigAtividadeDAO extends GenericDAO<ConfigAtividade> {
	
	public ConfigAtividadeDAO() {
		super(ConfigAtividade.class);
	}
	
	 
}