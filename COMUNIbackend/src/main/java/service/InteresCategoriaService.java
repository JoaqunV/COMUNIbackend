package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.InteresCategoriaFacade;
import model.InteresCategoria;

@Path("/interescategorias")
public class InteresCategoriaService {
	
	@EJB 
	InteresCategoriaFacade interesCategoriaEJB;
	
	Logger logger = Logger.getLogger(InteresCategoriaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<InteresCategoria> findAll(){
		return interesCategoriaEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public InteresCategoria find(@PathParam("id") Integer id) {
        return interesCategoriaEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(InteresCategoria entity) {
		interesCategoriaEJB.create(entity);
    }
}