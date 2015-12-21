package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.CategoriaEventoFacade;
import model.CategoriaEvento;

@Stateless
public class CategoriaEventoEJB  extends AbstractFacade<CategoriaEvento> implements CategoriaEventoFacade{

	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em; 
	
	public CategoriaEventoEJB() {
		super(CategoriaEvento.class); 
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}