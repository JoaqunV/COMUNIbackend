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
@Table(name="evento")
@NamedQuery(name="Evento.findAll", query="SELECT a FROM Evento a")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EVENTO", unique=true, nullable=false)
	private int eventId;
	
	@Column(name="ESTADO", nullable=false)
	private int eventEstado;
	
	@Column(name="POPULARIDAD", nullable=false)
	private int eventPopularidad;

	@Column(name="ID_COMUNA", nullable=false )
	private int eventComId;

	@Column(name="TITULO", nullable=false, length=100)
	private String eventTitulo;

	@Column(name="HORAINICIO", nullable=false, length=20)
	private String eventHoraInicio;
	
	@Column(name="HORAFIN", nullable=false, length=20)
	private String eventHoraFin;
	
	@Column(name="DIRECCIONEVENTO", nullable=false, length=50)
	private String eventDireccion;
	
	@Column(name="LATITUD", nullable=false, length=20)
	private String eventLatitud;
	
	@Column(name="LONGITUD", nullable=false, length=20)
	private String eventLongitud;
	
	@Column(name="PATHIMAGEN", nullable=false, length=50)
	private String eventPathImg;
	
	@Column(name="DESCRIPCION", nullable=false, length=400)
	private String eventDescripcion;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_COMUNA", referencedColumnName = "ID_COMUNA")
	private Comuna comuna;
	
	public int getEventId() {
		return this.eventId;
	}
	
	public void setEventId(int newId) {
		this.eventId = newId;
	}

	public int getEventoComunaId() {
		return this.eventComId;
	}

	public void setEventoComunaId(int newIdEventoComuna) {
		this.eventComId = newIdEventoComuna;
	}	
	
	public String getTitulo() {
		return this.eventTitulo;
	}

	public void setTitulo(String name) {
		this.eventTitulo = name;
	}

	public String getHoraInicio() {
		return this.eventHoraInicio;
	}

	public void setHoraInicio(String newHora) {
		this.eventHoraInicio = newHora;
	}
	
	public String getHoraTermino() {
		return this.eventHoraFin;
	}

	public void setHoraTermino(String newhoraFin) {
		this.eventHoraFin = newhoraFin;
	}
	
	public String getDireccion() {
		return this.eventDireccion;
	}

	public void setDireccion(String newDireccion) {
		this.eventDireccion = newDireccion;
	}
	
	public String getLatitud() {
		return this.eventLatitud;
	}

	public void setLatitud(String newLatitud) {
		this.eventLatitud = newLatitud;
	}
	
	public String getLongitud() {
		return this.eventLongitud;
	}

	public void setLongitud(String newLongitud) {
		this.eventLongitud = newLongitud;
	}

	public String getPathImagen() {
		return this.eventPathImg;
	}

	public void setPathImagen(String newPathImg) {
		this.eventPathImg = newPathImg;
	}
	
	public String getDescripcion() {
		return this.eventDescripcion;
	}

	public void setDescripcion(String newDescripcion) {
		this.eventDescripcion = newDescripcion;
	}
	
	public int getPopularidad() {
		return this.eventPopularidad;
	}

	public void setPopularidad(int newPopularidad) {
		this.eventPopularidad = newPopularidad;
	}
	
	public int getEstado() {
		return this.eventEstado;
	}

	public void setEstado(int newEstate) {
		this.eventEstado = newEstate;
	}	
	
	@OneToMany(mappedBy="evento")
	private List<CategoriaEvento> categorias;
	
	List<CategoriaEvento> getCategorias() {
		return categorias;
	}

	void setCategorias(List<CategoriaEvento> categorias) {
		this.categorias = categorias;
	}
	
	public List<Categoria> obtenerCategorias(){
		List<Categoria> lista = new ArrayList<Categoria>();
		for(CategoriaEvento Categoria : this.categorias){
			lista.add(Categoria.getCategoria());
		}
		return lista;
	}
	
	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
	
	
}