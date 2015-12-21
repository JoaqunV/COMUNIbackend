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
@Table(name="interesacategoria")
@NamedQuery(name="InteresCategoria.findAll", query="SELECT a FROM InteresCategoria a")
public class InteresCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORIA", unique=true, nullable=false)
	private int interesCategoriaId;
	
	@Id
	@Column(name="ID_USUARIO", unique=true, nullable=false)
	private int interesCategoriaIdUser;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
	private Categoria categoria;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;
	
	public int getInteresCategoriaId() {
		return this.interesCategoriaId;
	}

	public void setInteresCategoriaId(int newId) {
		this.interesCategoriaId = newId;
	}
	
	public int getInteresCategoriaIdUser() {
		return this.interesCategoriaIdUser;
	}

	public void setInteresCategoriaIdUser(int newId) {
		this.interesCategoriaIdUser = newId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	} 

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}