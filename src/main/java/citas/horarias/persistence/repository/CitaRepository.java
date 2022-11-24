package citas.horarias.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import citas.horarias.persistence.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
	
	public List<Cita> findByFechaCita(LocalDate fecha);
	
	

}
