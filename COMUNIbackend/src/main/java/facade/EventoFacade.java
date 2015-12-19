package facade;

import java.util.List;

import javax.ejb.Local;

import model.Evento;

@Local
public interface UsuarioFacade {

	public void create(Usuario entity);

	public void edit(Usuario entity);

	public void remove(Usuario entity);

	public Usuario find(Object id);

	public List<Usuario> findAll();

	public List<Usuario> findRange(int[] range);

	public int count();

}