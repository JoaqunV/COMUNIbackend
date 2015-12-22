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
@Table(name="comuna")
@NamedQuery(name="Comuna.findAll", query="SELECT a FROM Comuna a")
public class Comuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_COMUNA", unique=true, nullable=false)
	private int comunaId;

	@Column(name="NOMBRECOMUNA", nullable=false, length=100)
	private String comunaNombre;

	public int getComunaId() {
		return this.comunaId;
	}
	
	public void setComunaId(int newId) {
		this.comunaId = newId;
	}
	
	public String setNombreComuna(){
		return this.comunaNombre;
	}
	
	public void setNombreComuna(String newName){
		this.comunaNombre = newName;
	}
}