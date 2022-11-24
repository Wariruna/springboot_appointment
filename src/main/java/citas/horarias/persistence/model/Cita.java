package citas.horarias.persistence.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long citaId;
	
	@Column(name="nombre_cliente")
	private String nombreUsuario;
	@Column(name="dia_cita")
	private LocalDate fechaCita;
	@Column(name="hora_inicio")
	private LocalTime horaInicio;
	@Column(name="hora_fin")
	private LocalTime horaFin;
	@Column(name="telefono")
	private String telefono;
	@Column(name="email")
	private String email;
	@ManyToOne
	@JoinColumn(name="tratamiento_id")
	private Tratamiento tratamiento;
	
	//---------------------------Builders-------------------------------------.
	public Cita() {
		
	}

	public Cita(String nombreUsuario, LocalDate fechaCita, LocalTime horaInicio, LocalTime horaFin, String teléfono,
			String email, Tratamiento tratamiento) {
		this.nombreUsuario = nombreUsuario;
		this.fechaCita = fechaCita;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.telefono = teléfono;
		this.email = email;
		this.tratamiento = tratamiento;
	}

	
	//-----------------------Getters and Setters -----------------------------------------
	
	public Long getCitaId() {
		return citaId;
	}

	public void setCitaId(Long citaId) {
		this.citaId = citaId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	

	
	
	
	
	

}
