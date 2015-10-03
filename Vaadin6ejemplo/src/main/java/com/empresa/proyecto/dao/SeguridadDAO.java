package com.empresa.proyecto.dao;

import java.util.List;

import com.empresa.proyecto.bean.Opcion;
import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.util.AlertaException;

public interface SeguridadDAO {

	public Usuario login(String usuario, String clave) throws AlertaException;
	
	public List<Opcion> obtenerOpciones(Usuario usuario) throws AlertaException;
	
}
