package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="categoriaevento")
@NamedQuery(name="CategoriaEvento.findAll", query="SELECT a FROM CategoriaEvento a")
@IdClass(RelationCategoriaEvento.class)
public class CategoriaEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORIA", unique=true, nullable=false)
	private int categoriaId;
	
	@Id
	@Column(name="ID_EVENTO", unique=true, nullable=false)
	private int eventoId;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
	private Categoria categoria;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_EVENTO", referencedColumnName = "ID_EVENTO")
	private Evento evento;
	
	public int getCategoriaId() {
		return this.categoriaId;
	}

	public void getCategoriaId(int newId) {
		this.categoriaId = newId;
	}
	
	public int getEventoId() {
		return this.eventoId;
	}

	public void getEventoId(int newId) {
		this.eventoId = newId;
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Categoria getCategoria() {
		return categoria;
	} 

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}