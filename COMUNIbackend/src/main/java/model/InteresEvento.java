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
@Table(name="interesaevento")
@NamedQuery(name="InteresEvento.findAll", query="SELECT a FROM InteresEvento a")
public class InteresEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_evento", unique=true, nullable=false)
	private int interesEventoId;
	
	@Id
	@Column(name="ID_USUARIO", unique=true, nullable=false)
	private int interesEventoIdUser;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_EVENTO", referencedColumnName = "ID_EVENTO")
	private Evento evento;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;
	
	public int getInteresEventoId() {
		return this.interesEventoId;
	}

	public void setInteresEventoId(int newId) {
		this.interesEventoId = newId;
	}
	
	public int getInteresEventoIdUser() {
		return this.interesEventoIdUser;
	}

	public void setInteresEventoIdUser(int newId) {
		this.interesEventoIdUser = newId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	} 

	public void setevento(Evento evento) {
		this.evento = evento;
	}
}