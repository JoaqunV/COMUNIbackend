package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.ActorFacade;
import model.Actor;

@Stateless
public class UsuarioEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public ActorFacadeEJB() {
		super(Actor.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}