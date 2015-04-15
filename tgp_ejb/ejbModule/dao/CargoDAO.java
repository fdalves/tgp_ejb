package dao;

import javax.ejb.Stateless;

import model.Cargo;



@Stateless
public class CargoDAO extends GenericDAO<Cargo> {
	
	public CargoDAO() {
		super(Cargo.class);
	}
	
	 
}