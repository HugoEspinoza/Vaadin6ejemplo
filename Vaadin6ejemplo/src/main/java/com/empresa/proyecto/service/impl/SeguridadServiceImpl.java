package com.empresa.proyecto.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.empresa.proyecto.bean.Opcion;
import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.dao.SeguridadDAO;
import com.empresa.proyecto.service.SeguridadService;
import com.empresa.proyecto.util.AlertaException;

import static com.empresa.proyecto.util.Constante.CODIGO_MENSAJE.VALIDAR_TEXTBOX;
import static com.empresa.proyecto.util.Constante.CODIGO_MENSAJE.NO_USERNAME_REGISTRADO;
import static com.empresa.proyecto.util.Constante.CODIGO_MENSAJE.ERROR_GENERICO;
import static com.empresa.proyecto.util.Constante.CODIGO_MENSAJE.NO_OPCIONES_REGISTRADAS;
import static com.empresa.proyecto.util.Constante.TITULO_FORMULARIO;

@Service
public class SeguridadServiceImpl implements SeguridadService {

	
	private SeguridadDAO seguridadDAO;
	
	@Override
	public Usuario login(String usuario, String clave) throws AlertaException {

		if (StringUtils.isBlank(usuario)) {
			throw new AlertaException(TITULO_FORMULARIO.LOGIN, VALIDAR_TEXTBOX, new Object[] { "Usuario" });
		}

		if (StringUtils.isBlank(clave)) {
			throw new AlertaException(TITULO_FORMULARIO.LOGIN, VALIDAR_TEXTBOX, new Object[] { "Clave" });
		}

		usuario = usuario.toUpperCase();
		Usuario user = null;
		
		try {
			user = seguridadDAO.login(usuario, clave);
		} catch (Exception e) {
			throw new AlertaException(TITULO_FORMULARIO.LOGIN, ERROR_GENERICO, null);
		}
		
		if (user == null) {
			throw new AlertaException(TITULO_FORMULARIO.LOGIN, NO_USERNAME_REGISTRADO, new Object[] { usuario });
		}
		
		return user;
	}

	
	@Override
	public List<Opcion> obtenerOpciones(Usuario usuario) throws AlertaException {
		
		List<Opcion> listaOpciones =  seguridadDAO.obtenerOpciones(usuario);
		
		if(listaOpciones.isEmpty()){
			throw new AlertaException(TITULO_FORMULARIO.LOGIN, NO_OPCIONES_REGISTRADAS, new Object[] { usuario });
		}
		
		return listaOpciones;
	}

	
	public void setSeguridadDAO(SeguridadDAO seguridadDAO) {
		this.seguridadDAO = seguridadDAO;
	}
	
}
