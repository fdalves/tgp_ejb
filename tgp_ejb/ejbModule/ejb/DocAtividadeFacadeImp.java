package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.DocAtividade;
import model.DocProjeto;
import dao.DocAtividadeDAO;
import dao.DocProjetoDAO;



/**
 * Session Bean implementation class DocProjetoFacadeImp
 */
@Stateless
  public class DocAtividadeFacadeImp implements DocAtividadeFacade {

    @EJB
    private DocAtividadeDAO dao;
    
   
   
    
    public DocAtividadeFacadeImp() {
    	
    }

	@Override
	public void save(DocAtividade e) {
		dao.save(e);		
		
	}

	@Override
	public DocAtividade update(DocAtividade e) {		
		return dao.update(e);
	}

	@Override
	public void delete(DocAtividade doc) {
		dao.delete(doc);
	}

	@Override
	public DocAtividade find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<DocAtividade> findAll() {
		
		return dao.findAll();
	}

	

	

	
	
}
