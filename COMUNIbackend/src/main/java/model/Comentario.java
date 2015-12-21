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
@Table(name="comentario")
@NamedQuery(name="Comentario.findAll", query="SELECT a FROM Comentario a")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMENTARIO", unique=true, nullable=false)
	private int comentarioId;
	
	@Column(name="ID_EVENTO", nullable=false)
	private int comentarioEventId;
	
	@Column(name="ID_USUARIO", nullable=false)
	private int comentarioUserId;

	@Column(name="TEXTOCOMENTARIO", nullable=false )
	private String comentarioTexto;

	@Column(name="FECHACOMENTARIO", nullable=false, length=100)
	private String comentarioFecha;
	
	public int getComentarioId() {
		return this.comentarioId;
	}
	
	public void setComentarioId(int newId) {
		this.comentarioId = newId;
	}
	
	public int getComentarioEventoId() {
		return this.comentarioEventId;
	}
	
	public void setComentarioEventoId(int newId) {
		this.comentarioEventId = newId;
	}
	
	public int getComentarioUsuarioId() {
		return this.comentarioUserId;
	}
	
	public void setComentarioUsuarioId(int newId) {
		this.comentarioUserId = newId;
	}
	
	public String getTextoComentario(){
		return this.comentarioTexto;
	}
	
	public void setTextoComentario(String newText){
		this.comentarioTexto = newText;
	}
	
	public String getFechaComentario(){
		return this.comentarioFecha;
	}
	
	public void setFechaComentario(String newFecha){
		this.comentarioFecha = newFecha;
	}
	
}