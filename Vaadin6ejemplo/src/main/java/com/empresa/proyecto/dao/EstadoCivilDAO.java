package com.empresa.proyecto.dao;

import java.util.List;

import com.empresa.proyecto.bean.EstadoCivil;
import com.empresa.proyecto.util.AlertaException;

public interface EstadoCivilDAO {

	public List<EstadoCivil> listarEstadoCivil() throws AlertaException;
	
	public EstadoCivil obtenerEstadoCivil(Integer idEstadoCivil) throws AlertaException;
}
