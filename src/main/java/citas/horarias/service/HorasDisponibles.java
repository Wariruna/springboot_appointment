package citas.horarias.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citas.horarias.persistence.model.Cita;

@Service
public class HorasDisponibles {
	final private static LocalTime HORA_APERTURA = LocalTime.of(9, 30);
	final private static LocalTime HORA_CIERRE = LocalTime.of(20, 30);
	final private static int MINIM_TIEMPO_SERVICIO_MINUTOS = 15;
	final private static LocalTime HORA_CIERRE_ESPECIAL = LocalTime.of(14, 30); 

	@Autowired
	private CitaService citaService;
	@Autowired
	private TratamientoService tratamientoService;

	public List<LocalTime> horasDisponibles(LocalDate fecha, Long idTratamiento) {
		int duracionSesion = tratamientoService.getTratamiento(idTratamiento).get().getDuracion();
		boolean isFree = true;
		List<Cita> listCitas = citaService.citasPorDia(fecha);
		LocalTime horaAperTemporal = HORA_APERTURA;
		LocalTime horaCierTemporal = HORA_CIERRE;
		List<LocalTime> listHorasDisponibles = new ArrayList<LocalTime>();
		
		//Si es Sábado modifica la hora de cierre
		if (fecha.getDayOfWeek().getValue() == 6) {
			horaCierTemporal = HORA_CIERRE_ESPECIAL;
		}
		
		

		while (horaAperTemporal.isBefore(horaCierTemporal)
				&& horaAperTemporal.plusMinutes(duracionSesion - 1).isBefore(horaCierTemporal)) {
			if (listCitas.size() != 0) {
				for (Cita c : listCitas) {
					if ((horaAperTemporal.plusMinutes(duracionSesion).isAfter(c.getHoraInicio())
							&& horaAperTemporal.isBefore(c.getHoraFin()))
							|| horaAperTemporal.plusMinutes(duracionSesion).isAfter(horaCierTemporal)) {
						isFree = false;
					}
				}
			}
			if (isFree) {
				listHorasDisponibles.add(horaAperTemporal);
			}
			isFree = true;
			horaAperTemporal = horaAperTemporal.plusMinutes(MINIM_TIEMPO_SERVICIO_MINUTOS);
		}
		
		
		return listHorasDisponibles;
	}

}
