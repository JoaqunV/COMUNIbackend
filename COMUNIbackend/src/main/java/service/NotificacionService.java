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

import facade.NotificacionFacade;
import model.Notificacion;

@Path("/notificaciones")
public class NotificacionService {
	
	@EJB 
	NotificacionFacade notificacionEJB;
	
	Logger logger = Logger.getLogger(NotificacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Notificacion> findAll(){
		return notificacionEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Notificacion find(@PathParam("id") Integer id) {
        return notificacionEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Notificacion entity) {
		notificacionEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Notificacion entity) {
    	entity.setNotificacionId(id.intValue());
    	notificacionEJB.edit(entity);
    }
}