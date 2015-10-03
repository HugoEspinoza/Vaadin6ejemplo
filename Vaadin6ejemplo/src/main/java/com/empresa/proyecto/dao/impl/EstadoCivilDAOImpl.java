package com.empresa.proyecto.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.empresa.proyecto.bean.EstadoCivil;
import com.empresa.proyecto.dao.EstadoCivilDAO;
import com.empresa.proyecto.util.AlertaException;

@Repository
public class EstadoCivilDAOImpl implements EstadoCivilDAO {

    private SessionFactory sessionFactory;
    
	@Override
	public List<EstadoCivil> listarEstadoCivil() throws AlertaException {
		
		
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from EstadoCivil");
        @SuppressWarnings("unchecked")
		List<EstadoCivil> listaEstadoCivil = query.list();
        
		return listaEstadoCivil;
	}

	@Override
	public EstadoCivil obtenerEstadoCivil(Integer idEstadoCivil) throws AlertaException {

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from EstadoCivil where id= :idEstadoCivil");
        query.setParameter("idEstadoCivil", idEstadoCivil);
        EstadoCivil estado = (EstadoCivil) query.uniqueResult();
		return estado;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
