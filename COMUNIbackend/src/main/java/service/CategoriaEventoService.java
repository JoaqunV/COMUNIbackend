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

import facade.CategoriaEventoFacade;
import model.CategoriaEvento;

@Path("/categoriaevento")
public class CategoriaEventoService {
	
	@EJB 
	CategoriaEventoFacade categoriaEventoEJB;
	
	Logger logger = Logger.getLogger(CategoriaEventoService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<CategoriaEvento> findAll(){
		return categoriaEventoEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public CategoriaEvento find(@PathParam("id") Integer id) {
        return categoriaEventoEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(CategoriaEvento entity) {
		categoriaEventoEJB.create(entity);
    }
}