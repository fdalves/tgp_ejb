package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.DocProjeto;
import dao.DocProjetoDAO;



/**
 * Session Bean implementation class DocProjetoFacadeImp
 */
@Stateless
  public class DocProjetoFacadeImp implements DocProjetoFacade {

    @EJB
    private DocProjetoDAO dao;
    
   
   
    
    public DocProjetoFacadeImp() {
    	
    }

	@Override
	public void save(DocProjeto docProjeto) {
		dao.save(docProjeto);		
		
	}

	@Override
	public DocProjeto update(DocProjeto doc) {		
		return dao.update(doc);
	}

	@Override
	public void delete(DocProjeto doc) {
		dao.delete(doc);
	}

	@Override
	public DocProjeto find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<DocProjeto> findAll() {
		
		return dao.findAll();
	}

	

	

	
	
}
