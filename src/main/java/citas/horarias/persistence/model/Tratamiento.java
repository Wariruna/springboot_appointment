package citas.horarias.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tratamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tratamientoId;
	@Column(name="nombre")
	private String nombre;
	@Column(name="duracion")
	private int duracion;
	@Column(name="url_imagen")
	private String urlImg;
	
	
	//----------------------Builders--------------------------------
	
	public Tratamiento() {
		super();
	}
	public Tratamiento(String nombre, int duracion, String urlImg) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.urlImg = urlImg;
	}
	
	//----------------------------Getters and Setters------------------------
	
	public Long getTratamientoId() {
		return tratamientoId;
	}
	public void setTratamientoId(Long tratamientoId) {
		this.tratamientoId = tratamientoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	
	
	
	
}
