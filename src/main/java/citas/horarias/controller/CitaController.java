package citas.horarias.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import citas.horarias.dto.CitaDTO;
import citas.horarias.mapper.CitaDTOtoCita;
import citas.horarias.persistence.model.Cita;
import citas.horarias.service.CitaService;
import citas.horarias.service.HorasDisponibles;

@RestController
@RequestMapping("/")
@CrossOrigin("*")//Para fase de desarrollo, quitar en producción
public class CitaController {
	
	@Autowired
	CitaDTOtoCita mapper;
	@Autowired
	CitaService service;
	@Autowired
	HorasDisponibles horasDisponibles;
	
	@PostMapping("/cita")
	public Cita createCita(@RequestBody CitaDTO citaDto) {
		Cita newCita = new Cita();
		newCita = mapper.map(citaDto);
		System.out.println(citaDto);
		return service.createCita(newCita);
		
	}
	
	/*@GetMapping("/citas-disponibles/")
	public List<HorasDisponibles> horasDisponibles(@RequestParam int dia, @RequestParam int mes,@RequestParam int anio){
		return null;//CAMBIAR NULL
	}*/
	@GetMapping("/citas-disponibles")
	public List<LocalTime> horasDisponibles(@RequestParam Long idTratamiento, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia){
		return horasDisponibles.horasDisponibles(dia, idTratamiento);
		
		
	}

}
