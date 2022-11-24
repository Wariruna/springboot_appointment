package citas.horarias.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import citas.horarias.persistence.model.Tratamiento;


@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

}
