package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.UsuarioFacade;
import model.Usuario;

@Path("/usuarios")
public class UsuarioService {
	
	@EJB 
	UsuarioFacade usuarioEJB;
	
	Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(){
		return usuarioEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find(@PathParam("id") Integer id) {
        return usuarioEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
		usuarioEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
    	entity.setUserId(id.intValue());
    	usuarioEJB.edit(entity);
    }
    
    
    /*
    @PUT 
    @Path("{id}/{nombre}/{apellido}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id", "nombre", "apellido") Integer id, String nombre, String apellido, Usuario entity) {
    	entity.setUserNombre(nombre.StringValue());
    	entity.setUserNombre(nombre.StringValue());
    	usuarioEJB.edit(entity);
    }
    */
    
    /*
    @GET
    @Path("{id}/films")
    @Produces({"application/xml", "application/json"})
    public List<Film> find_films(@PathParam("id") Integer id) {
        return actorFacadeEJB.find(id).obtenerFilms();
    }
	*/

}
