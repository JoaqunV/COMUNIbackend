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

import facade.InteresEventoFacade;
import model.InteresEvento;

@Path("/intereseventos")
public class InteresEventoService {
	
	@EJB 
	InteresEventoFacade interesEventoEJB;
	
	Logger logger = Logger.getLogger(InteresEventoService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<InteresEvento> findAll(){
		return interesEventoEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public InteresEvento find(@PathParam("id") Integer id) {
        return interesEventoEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(InteresEvento entity) {
		interesEventoEJB.create(entity);
    }
}