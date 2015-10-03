package com.empresa.proyecto.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.dao.UsuarioDAO;
import com.empresa.proyecto.util.AlertaException;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private SessionFactory sessionFactory;
    
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

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Usuario");
        @SuppressWarnings("unchecked")
		List<Usuario> listaUsuarios = query.list();
        
		return listaUsuarios;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
