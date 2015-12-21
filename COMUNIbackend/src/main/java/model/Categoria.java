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
@Table(name="categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT a FROM Categoria a")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORIA", unique=true, nullable=false)
	private int categoriaId;

	@Column(name="NOMBRE", nullable=false, length=100)
	private String categoriaNombre;

	@Column(name="DESCRIPCION", nullable=false, length=100)
	private String categoriaDescripcion;
	
	@Column(name="POPULARIDAD", nullable=false)
	private int categoriaPopularidad;
	
	public int getCategoriaId() {
		return this.categoriaId;
	}
	
	public void setCategoriaId(int newId) {
		this.categoriaId = newId;
	}
	
	public String getNombreCategoria(){
		return this.categoriaNombre;
	}
	
	public void setNombreCategoria(String newText){
		this.categoriaNombre = newText;
	}
	
	public String getCategoriaDescripcion(){
		return this.categoriaDescripcion;
	}
	
	public void setCategoriaDescripcion(String newFecha){
		this.categoriaDescripcion = newFecha;
	}
	
	public int getCategoriaPopularidad() {
		return this.categoriaPopularidad;
	}
	
	public void setCategoriaPopularidad(int newId) {
		this.categoriaPopularidad = newId;
	}
	
	@OneToMany(mappedBy="categoria")
	private List<CategoriaEvento> eventos;
	
	List<CategoriaEvento> getEventos() {
		return eventos;
	}

	void setEventos(List<CategoriaEvento> eventos) {
		this.eventos = eventos;
	}
	
	public List<Evento> obtenerEventos(){
		List<Evento> lista = new ArrayList<Evento>();
		for(CategoriaEvento Eventos : this.eventos){
			lista.add(Eventos.getEvento());
		}
		return lista;
	}
}