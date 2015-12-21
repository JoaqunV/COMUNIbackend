package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.ComunaFacade;
import model.Comuna;

@Stateless
public class ComunaEJB extends AbstractFacade<Comuna> implements ComunaFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public ComunaEJB() {
		super(Comuna.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}