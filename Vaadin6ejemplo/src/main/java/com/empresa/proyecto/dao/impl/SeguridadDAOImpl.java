package com.empresa.proyecto.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.empresa.proyecto.bean.Opcion;
import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.dao.SeguridadDAO;
import com.empresa.proyecto.util.AlertaException;

@Repository
public class SeguridadDAOImpl implements SeguridadDAO{

    private SessionFactory sessionFactory;
    
	@Override
	public Usuario login(String usuario, String clave) throws AlertaException {

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Usuario where username= :usuario");
        query.setParameter("usuario", usuario);
        Usuario user = (Usuario) query.uniqueResult();
		return user;
	}

	@Override
	public List<Opcion> obtenerOpciones(Usuario usuario) throws AlertaException {

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Opcion where idusuario= :idusuario");
        query.setParameter("idusuario", usuario.getId());
        @SuppressWarnings("unchecked")
		List<Opcion> listaOpciones = query.list();
        
		return listaOpciones;
	}
    
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
