package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.ConfigAtividade;
import dao.ConfigAtividadeDAO;



/**
 * Session Bean implementation class ConfigAtividadeFacadeImp
 */
@Stateless
  public class ConfigAtividadeFacadeImp implements ConfigAtividadeFacade {

    @EJB
    private ConfigAtividadeDAO dao;
    
   
   
    
    public ConfigAtividadeFacadeImp() {
    	
    }

	@Override
	public void save(ConfigAtividade confAtividade) {
		dao.save(confAtividade);		
		
	}

	@Override
	public ConfigAtividade update(ConfigAtividade confAtividade) {		
		return dao.update(confAtividade);
	}

	@Override
	public void delete(ConfigAtividade confAtividade) {
		dao.delete(confAtividade);
	}

	@Override
	public ConfigAtividade find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<ConfigAtividade> findAll() {
		
		return dao.findAll();
	}

	

	

	
	
}
