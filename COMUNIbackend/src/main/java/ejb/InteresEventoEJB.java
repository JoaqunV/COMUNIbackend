package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.InteresEventoFacade;
import model.InteresEvento;

@Stateless
public class InteresEventoEJB extends AbstractFacade<InteresEvento> implements InteresEventoFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public InteresEventoEJB() {
		super(InteresEvento.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}