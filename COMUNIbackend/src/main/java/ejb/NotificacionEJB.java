package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.NotificacionFacade;
import model.Notificacion;

@Stateless
public class NotificacionEJB extends AbstractFacade<Notificacion> implements NotificacionFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public NotificacionEJB() {
		super(Notificacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

}