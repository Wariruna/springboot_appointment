package citas.horarias.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDTO {
	

	private String nombreUsuario;
	
	private LocalDate fechaCita;
	
	private LocalTime horaInicio;
	
	private String telefono;
	
	private String email;
	
	private TratamientoDTO tratamientoDto;

	public CitaDTO() {
		super();
	}

	public CitaDTO(String nombreUsuario, LocalDate fechaCita, LocalTime horaInicio, String teléfono, String email,
			TratamientoDTO tratamientoDto) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.fechaCita = fechaCita;
		this.horaInicio = horaInicio;
		this.telefono = teléfono;
		this.email = email;
		this.tratamientoDto = tratamientoDto;
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

	public TratamientoDTO getTratamientoDto() {
		return tratamientoDto;
	}

	public void setTratamientoDto(TratamientoDTO tratamientoDto) {
		this.tratamientoDto = tratamientoDto;
	}
	
	

}
