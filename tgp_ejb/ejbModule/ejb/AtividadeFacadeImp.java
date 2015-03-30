package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Atividade;
import dao.AtividadeDAO;



/**
 * Session Bean implementation class AtividadeFacadeImp
 */
@Stateless
  public class AtividadeFacadeImp implements AtividadeFacade {

    @EJB
    private AtividadeDAO dao;
    
   
   
    
    public AtividadeFacadeImp() {
    	
    }

	@Override
	public void save(Atividade atividade) {
		dao.save(atividade);		
		
	}

	@Override
	public Atividade update(Atividade atividade) {		
		return dao.update(atividade);
	}

	@Override
	public void delete(Atividade atividade) {
		dao.delete(atividade);
	}

	@Override
	public Atividade find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<Atividade> findAll() {
		
		return dao.findAll();
	}

	

	

	
	
}
