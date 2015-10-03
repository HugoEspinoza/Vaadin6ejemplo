package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.bean.EstadoCivil;
import com.empresa.proyecto.util.AlertaException;

public interface EstadoCivilService {

	public List<EstadoCivil> listarEstadoCivil() throws AlertaException;
	
	public EstadoCivil obtenerEstadoCivil(Integer idEstadoCivil) throws AlertaException;
	
}
