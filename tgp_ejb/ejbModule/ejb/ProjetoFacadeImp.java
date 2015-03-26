package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Projeto;
import dao.ProjetoDAO;



/**
 * Session Bean implementation class ProjetoFacadeImp
 */
@Stateless
  public class ProjetoFacadeImp implements ProjetoFacade {

    @EJB
    private ProjetoDAO dao;
    
   
   
    
    public ProjetoFacadeImp() {
    	
    }

	@Override
	public void save(Projeto projeto) {
		dao.save(projeto);		
		
	}

	@Override
	public Projeto update(Projeto projeto) {		
		return dao.update(projeto);
	}

	@Override
	public void delete(Projeto projeto) {
		dao.delete(projeto);
	}

	@Override
	public Projeto find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<Projeto> findAll() {
		
		return dao.findAll();
	}

	@Override
	public List<Projeto> listarPorNomeProjeto(String nomeProjeto) {
		return dao.listarPorNomeProjeto(nomeProjeto);
	}

	@Override
	public List<Projeto> listarPorSiglaProjeto(String siglaProjeto) {
		return dao.listarPorSiglaProjeto(siglaProjeto);
	}


	

	
	
}
