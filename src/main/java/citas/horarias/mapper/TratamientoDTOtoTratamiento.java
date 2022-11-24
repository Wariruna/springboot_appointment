package citas.horarias.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import citas.horarias.dto.TratamientoDTO;
import citas.horarias.persistence.model.Tratamiento;
import citas.horarias.service.TratamientoService;

@Component
public class TratamientoDTOtoTratamiento implements IMapper<TratamientoDTO, Tratamiento>{
	@Autowired
	TratamientoService service;

	@Override
	public Tratamiento map(TratamientoDTO in) {
		Tratamiento tratamientoEscogido = new Tratamiento();
		Tratamiento tratamientoABuscar = service.getTratamiento(in.getTratamientoIdDto()).get();
		tratamientoEscogido.setTratamientoId(in.getTratamientoIdDto());
		tratamientoEscogido.setNombre(tratamientoABuscar.getNombre());
		tratamientoEscogido.setDuracion(tratamientoABuscar.getDuracion());
		return tratamientoEscogido;
	}

}
