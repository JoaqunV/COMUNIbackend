package facade;

import java.util.List;

import javax.ejb.Local;

import model.CategoriaEvento;

@Local
public interface CategoriaEventoFacade {

	public void create(CategoriaEvento entity);

	public void edit(CategoriaEvento entity);

	public void remove(CategoriaEvento entity);

	public CategoriaEvento find(Object id);

	public List<CategoriaEvento> findAll();

	public List<CategoriaEvento> findRange(int[] range);

	public int count();
}
