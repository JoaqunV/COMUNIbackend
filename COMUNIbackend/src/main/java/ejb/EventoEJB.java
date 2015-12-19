package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Usuario;

@Stateless
public class EventoEJB extends AbstractFacade<Evento> implements EventoFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public EventoEJB() {
		super(Evento.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}