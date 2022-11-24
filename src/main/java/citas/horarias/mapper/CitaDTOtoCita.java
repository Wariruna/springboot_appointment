package citas.horarias.mapper;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import citas.horarias.dto.CitaDTO;
import citas.horarias.persistence.model.Cita;

@Component
public class CitaDTOtoCita implements IMapper<CitaDTO, Cita>{
	@Autowired
	private TratamientoDTOtoTratamiento mapper;

	
	public Cita map(CitaDTO in) {
		Cita cita = new Cita();
		cita.setNombreUsuario(in.getNombreUsuario());
		cita.setEmail(in.getEmail());
		cita.setFechaCita(in.getFechaCita());
		cita.setHoraInicio(in.getHoraInicio());
		cita.setHoraFin(calculateFinishHour(in.getHoraInicio(), mapper.map(in.getTratamientoDto()).getDuracion()));
		cita.setTelefono(in.getTelefono());
		cita.setTratamiento(mapper.map(in.getTratamientoDto()));
		return cita;
	}
	
	private LocalTime calculateFinishHour(LocalTime horaInicio, int duracion) {
		return horaInicio.plusMinutes(duracion);
	}

	
}
