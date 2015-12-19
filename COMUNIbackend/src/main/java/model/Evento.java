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
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EVENTO", unique=true, nullable=false)
	private int eventID;
	
	@Column(name="ID_CATEGORIA", nullable=false)
	private int eventCatId;

	@Column(name="ID_COMUNA", nullable=false )
	private int eventComId;

	@Column(name="TITULO", nullable=false, length=100)
	private String eventTitulo;

	@Column(name="HORAINICIO", nullable=false, length=20)
	private String eventHoraInciio;
	
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
	
	@Column(name="ESTADO", nullable=false )
	private int eventEstado;
	
	@Column(name="POPULARIDAD", nullable=false, length=30)
	private String eventPopularidad;

	public class Evento() {
	}

	public int getUserId() {
		return this.userId;
	}
	
	public int getUserIdComuna() {
		return this.userIdComuna;
	}
	
	public void setUserIdComuna(int newIdComuna) {
		 this.userIdComuna = newIdComuna;
	}
	
	public void setUserId(int newId) {
		this.userId = newId;
	}

	public int getTipo() {
		return this.userTipo;
	}

	public void setTipo(int tipoUser) {
		this.userTipo = tipoUser;
	}	
	
	public String getNombre() {
		return this.userNombre;
	}

	public void setNombre(String name) {
		this.userNombre = name;
	}

	public String getApellido() {
		return this.userApellido;
	}

	public void setApellido(String newApellido) {
		this.userApellido = newApellido;
	}
	
	public String getPassword() {
		return this.userPassword;
	}

	public void setPassword(String newPassword) {
		this.userPassword = newPassword;
	}
	
	public String getEmail() {
		return this.userEmail;
	}

	public void setEmail(String newEmail) {
		this.userEmail = newEmail;
	}
	
	public String getFechaNac() {
		return this.userNacimiento;
	}

	public void setFechaNac(String newFecha) {
		this.userNacimiento = newFecha;
	}

	public String getDireccion() {
		return this.userDireccion;
	}

	public void setDireccion(String newDireccion) {
		this.userDireccion = newDireccion;
	}
	
	public String getTelefono() {
		return this.userTelefono;
	}

	public void setTelefono(String newTelefono) {
		this.userTelefono = newTelefono;
	}
	
	/*
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}
	
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@OneToMany(mappedBy="actor")
	private List<Film_Actor> films;
	
	List<Film_Actor> getFilms() {
		return films;
	}

	void setFilms(List<Film_Actor> films) {
		this.films = films;
	}
	
	public List<Film> obtenerFilms(){
		List<Film> lista = new ArrayList<Film>();
		for(Film_Actor Film : this.films){
			lista.add(Film.getFilm());
		}
		return lista;
	}
	*/

}