package citas.horarias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import citas.horarias.persistence.model.Tratamiento;
import citas.horarias.persistence.repository.TratamientoRepository;

@Service
public class TratamientoService {
	
	TratamientoRepository repo;
	
	public TratamientoService( TratamientoRepository repo) {
		this.repo = repo;
	}
	
	//-------------------Methods Services------------------------------------------
	
	public Optional<Tratamiento> getTratamiento(Long id) {
		return repo.findById(id);
	}
	
	public List<Tratamiento> getAllTratamientos(){
		return repo.findAll();
	}

}
