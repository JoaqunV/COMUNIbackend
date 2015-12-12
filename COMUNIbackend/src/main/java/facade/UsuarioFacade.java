package facade;

import java.util.List;

import javax.ejb.Local;

import model.Actor;

@Local
public interface ActorFacade {

	public void create(Usuario entity);

	public void edit(Usuario entity);

	public void remove(Usuario entity);

	public Actor find(Object id);

	public List<Usuario> findAll();

	public List<Usuario> findRange(int[] range);

	public int count();

}