package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.util.AlertaException;

public interface UsuarioService {

	public void crearUsuario(Usuario usuario) throws AlertaException;
	
	public void actualizarUsuario(Usuario usuario) throws AlertaException; 
	
	public void eliminarUsuario(Integer idusuario) throws AlertaException; 
	
	public List<Usuario> listarUsuarios() throws AlertaException;
}
