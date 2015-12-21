package facade;

import java.util.List;

import javax.ejb.Local;

import model.InteresCategoria;

@Local
public interface InteresCategoriaFacade {

	public void create(InteresCategoria entity);

	public void edit(InteresCategoria entity);

	public void remove(InteresCategoria entity);

	public InteresCategoria find(Object id);

	public List<InteresCategoria> findAll();

	public List<InteresCategoria> findRange(int[] range);

	public int count();

}