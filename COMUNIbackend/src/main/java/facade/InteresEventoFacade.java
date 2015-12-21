package facade;

import java.util.List;

import javax.ejb.Local;

import model.InteresEvento;

@Local
public interface InteresEventoFacade {

	public void create(InteresEvento entity);

	public void edit(InteresEvento entity);

	public void remove(InteresEvento entity);

	public InteresEvento find(Object id);

	public List<InteresEvento> findAll();

	public List<InteresEvento> findRange(int[] range);

	public int count();

}