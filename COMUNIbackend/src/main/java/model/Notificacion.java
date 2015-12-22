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
@Table(name="notificacion")
@NamedQuery(name="Notificacion.findAll", query="SELECT a FROM Notificacion a")
public class Notificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NOTIFICACION", unique=true, nullable=false)
	private int notificacionId;
	
	@Column(name="ID_EVENTO", unique=true, nullable=false)
	private int notificacionEventoId;
	
	@Column(name="ID_USUARIO", nullable=false)
	private int notificacionUserId;
	
	@Column(name="ID_TIPONOTIFICACION", nullable=false)
	private int notificacionTipo;
	
	@Column(name="TEXTONOTIFICACION", nullable=false, length=200)
	private String notificacionTexto;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_TIPONOTIFICACION", referencedColumnName = "ID_TIPONOTIFICACION")
	private TipoNotificacion notificacion;
	
	public int getNotificacionId() {
		return this.notificacionId;
	}
	
	public void setNotificacionId(int newId) {
		this.notificacionId = newId;
	}
	
	public int getNotificacionEventoId() {
		return this.notificacionEventoId;
	}
	
	public void setNotificacionEventoId(int newId) {
		this.notificacionEventoId = newId;
	}
	
	public int getNotificacionUsuarioId() {
		return this.notificacionUserId;
	}
	
	public void setNotificacionUsuarioId(int newId) {
		this.notificacionUserId = newId;
	}
	
	public int getNotificacionTipoId() {
		return this.notificacionTipo;
	}
	
	public void setNotificacionTipoId(int newId) {
		this.notificacionTipo = newId;
	}
	
	public String getTextoNotificacion(){
		return this.notificacionTexto;
	}
	
	public void setTextoNotificacion(String newText){
		this.notificacionTexto = newText;
	}
	
	public TipoNotificacion getTipoNotificacion() {
		return notificacion;
	}

	public void setTipoNotificacion(TipoNotificacion notificacion) {
		this.notificacion = notificacion;
	}
}