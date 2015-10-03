package com.empresa.proyecto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.dao.UsuarioDAO;
import com.empresa.proyecto.service.UsuarioService;
import com.empresa.proyecto.util.AlertaException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	@Override
	public void crearUsuario(Usuario usuario) throws AlertaException {
		// TODO Auto-generated method stub
	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws AlertaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Integer idusuario) throws AlertaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listarUsuarios() throws AlertaException {

		List<Usuario> listaUsuarios =  usuarioDAO.listarUsuarios();
		
		return listaUsuarios;
	}

	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
