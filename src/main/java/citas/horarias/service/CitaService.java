package citas.horarias.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citas.horarias.persistence.model.Cita;
import citas.horarias.persistence.model.Tratamiento;
import citas.horarias.persistence.repository.CitaRepository;
import citas.horarias.persistence.repository.TratamientoRepository;

@Service
public class CitaService {
	
	@Autowired
	CitaRepository ctRepo;
	
	TratamientoRepository trRepo;
	
	 CitaService(CitaRepository ctRepo, TratamientoRepository trRepo){
		 this.ctRepo = ctRepo;
		 this.trRepo = trRepo;
	 }
	 
	 //Crear una Cita se necesita recuperar primero el tratamiento para la duración que tendrá la misma
	 
	 public Optional<Tratamiento> getTratamiento(Long id) {
		 return trRepo.findById(id);
	 }
	 
	 public Cita createCita(Cita cita) {
		 return ctRepo.save(cita);
	 }
	 
	 public List<Cita> citasPorDia(LocalDate fecha){
		return ctRepo.findByFechaCita(fecha);
	 }
	 
	 
	 

}
