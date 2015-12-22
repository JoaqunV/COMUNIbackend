package facade;

import java.util.List;

import javax.ejb.Local;

import model.Notificacion;

@Local
public interface NotificacionFacade {

	public void create(Notificacion entity);

	public void edit(Notificacion entity);

	public void remove(Notificacion entity);

	public Notificacion find(Object id);

	public List<Notificacion> findAll();

	public List<Notificacion> findRange(int[] range);

	public int count();
}