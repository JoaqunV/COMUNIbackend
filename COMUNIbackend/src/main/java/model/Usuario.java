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
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT a FROM Usuario a")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO", unique=true, nullable=true)
	private int userId;
	
	@Column(name="ID_COMUNA")
	private int userIdComuna;

	@Column(name="TIPO" )
	private int userTipo;

	@Column(name="NOMBRE", length=100)
	private String userNombre;

	@Column(name="APELLIDO", length=120)
	private String userApellido;
	
	@Column(name="PASSWORD", length=50)
	private String userPassword;
	
	@Column(name="EMAIL", length=50)
	private String userEmail;
	
	@Column(name="FECHANACIMIENTO", length=10)
	private String userNacimiento;
	
	@Column(name="DIRECCIONUSUARIO", length=200)
	private String userDireccion;
	
	@Column(name="TELEFONO", length=30)
	private String userTelefono;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ID_COMUNA", referencedColumnName = "ID_COMUNA")
	private Comuna comuna;
	
	

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
	
	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
	
}