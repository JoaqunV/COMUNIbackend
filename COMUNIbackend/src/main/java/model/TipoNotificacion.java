package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="tiponotificacion")
@NamedQuery(name="TipoNotificacion.findAll", query="SELECT a FROM TipoNotificacion a")
public class TipoNotificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPONOTIFICACION", unique=true, nullable=false)
	private int tiponotificacionId;

	@Column(name="DESCRIPCION", nullable=false, length=100)
	private String tiponotificacionDescripcion;
	
	public int getTipoNotificacionId() {
		return this.tiponotificacionId;
	}
	
	public void setTipoNotificacionId(int newId) {
		this.tiponotificacionId = newId;
	}
	
	public String getTipoNotificacionDescripcion(){
		return this.tiponotificacionDescripcion;
	}
	
	public void setTipoNotificacionDescripcion(String newText){
		this.tiponotificacionDescripcion = newText;
	}
}