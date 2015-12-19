package facade;

import java.util.List;

import javax.ejb.Local;

import model.Evento;

@Local
public interface EventoFacade {

	public void create(Evento entity);

	public void edit(Evento entity);

	public void remove(Evento entity);

	public Evento find(Object id);

	public List<Evento> findAll();

	public List<Evento> findRange(int[] range);

	public int count();

}