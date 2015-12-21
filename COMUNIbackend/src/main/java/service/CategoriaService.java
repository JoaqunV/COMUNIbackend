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

import facade.CategoriaFacade;
import model.Categoria;

@Path("/categorias")
public class CategoriaService {
	
	@EJB 
	CategoriaFacade categoriaEJB;
	
	Logger logger = Logger.getLogger(EventoService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Categoria> findAll(){
		return categoriaEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Categoria find(@PathParam("id") Integer id) {
        return categoriaEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Categoria entity) {
		categoriaEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Categoria entity) {
    	entity.setCategoriaId(id.intValue());
    	categoriaEJB.edit(entity);
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