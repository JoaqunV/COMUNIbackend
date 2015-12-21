package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.InteresCategoriaFacade;
import model.InteresCategoria;

@Stateless
public class InteresCategoriaEJB extends AbstractFacade<InteresCategoria> implements InteresCategoriaFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public InteresCategoriaEJB() {
		super(InteresCategoria.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}