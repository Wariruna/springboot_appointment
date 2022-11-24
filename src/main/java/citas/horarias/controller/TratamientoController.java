package citas.horarias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import citas.horarias.persistence.model.Tratamiento;
import citas.horarias.service.TratamientoService;

@RestController
@RequestMapping("/tratamientos")
@CrossOrigin("*")
public class TratamientoController {
	
	@Autowired
	TratamientoService service;
	
	@GetMapping("/")
	public List<Tratamiento> getAllTratamientos(){
		return service.getAllTratamientos();
	}
	

}
