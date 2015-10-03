package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.bean.Opcion;
import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.util.AlertaException;

public interface SeguridadService {

	Usuario login(String usuario, String clave) throws AlertaException;
	
	List<Opcion> obtenerOpciones(Usuario usuario) throws AlertaException;
}
