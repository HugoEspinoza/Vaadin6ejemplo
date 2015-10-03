package com.empresa.proyecto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.proyecto.bean.EstadoCivil;
import com.empresa.proyecto.dao.EstadoCivilDAO;
import com.empresa.proyecto.service.EstadoCivilService;
import com.empresa.proyecto.util.AlertaException;

@Service 
public class EstadoCivilServiceImpl implements EstadoCivilService {

	private EstadoCivilDAO estadoCivilDAO;
	
	@Override
	public List<EstadoCivil> listarEstadoCivil() throws AlertaException {
		
		List<EstadoCivil> listaEstadoCivil =  estadoCivilDAO.listarEstadoCivil();
		return listaEstadoCivil;
	}

	@Override
	public EstadoCivil obtenerEstadoCivil(Integer idEstadoCivil) throws AlertaException {
		
		EstadoCivil estadoCivil = estadoCivilDAO.obtenerEstadoCivil(idEstadoCivil);
		return estadoCivil;
	}
	
	
	public void setEstadoCivilDAO(EstadoCivilDAO estadoCivilDAO) {
		this.estadoCivilDAO = estadoCivilDAO;
	}

}
