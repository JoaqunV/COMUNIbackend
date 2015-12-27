package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.*;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Usuario;

@Stateless
public class UsuarioEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "comuniPU")
	private EntityManager em;
	
	public UsuarioEJB() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	UsuarioEJB usuarioFacade;
	
	@Override
	public int Login(Usuario usuario){
		 List <Usuario> list = usuarioFacade.findAll();
         int largo = list.size();
         int contador = 0;
         while(largo != 0){
             if(usuario.getEmail().equals(list.get(contador).getEmail()) && usuario.getPassword().equals(list.get(contador).getPassword())){
                 return list.get(contador).getUserId();
             }
             contador++;
             largo--;
         }
         return -1;   
	}
	
}