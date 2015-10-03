package com.empresa.proyecto.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.empresa.proyecto.bean.Empleado;
import com.empresa.proyecto.dao.EmpleadoDAO;
import com.empresa.proyecto.util.AlertaException;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	private SessionFactory sessionFactory; 
	
	@Override
	public void crearEmpleado(Empleado empleado) throws AlertaException {
		
		Session session = this.sessionFactory.openSession();
		
		try {
			session.getTransaction().begin();
			
			session.save(empleado);
			
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}	        
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) throws AlertaException {

		Session session = this.sessionFactory.openSession();
		
		try {
			session.getTransaction().begin();
			
			session.update(empleado);
			
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}	
	}

	@Override
	public void eliminarEmpleado(Integer idEmpleado) throws AlertaException {

		Session session = this.sessionFactory.openSession();
		
	      try{
	    	  session.getTransaction().begin();
	    	  Empleado empleado = (Empleado)session.get(Empleado.class, idEmpleado); 
	    	  session.delete(empleado); 
	    	  session.getTransaction().commit();
	    	  
	      }catch (HibernateException e) {
	    	  e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}

	@Override
	public List<Empleado> listarEmpleados() throws AlertaException {

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Empleado");
        @SuppressWarnings("unchecked")
		List<Empleado> listaEmpleados = query.list();
		return listaEmpleados;
	}

	
	@Override
	public List<Empleado> buscarEmpleadosPorFiltros(Empleado empleado) throws AlertaException {

		Session session = this.sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Empleado.class);
		if (empleado.getId() != null) {
			criteria.add(Restrictions.eq("id",empleado.getId()));
		}
		if (empleado.getNombre() != null) {
			criteria.add(Restrictions.ilike("nombre",empleado.getNombre(), MatchMode.ANYWHERE));
		}
		if (empleado.getApellido() != null) {
			criteria.add(Restrictions.ilike("apellido",empleado.getApellido(), MatchMode.ANYWHERE));
		}
		if (empleado.getEstadoCivil() != null) {
			Criteria criteriaEstadoCivil = criteria.createCriteria("estadoCivil");
			criteriaEstadoCivil.add(Restrictions.ilike("descripcion",empleado.getEstadoCivil().getDescripcion(), MatchMode.ANYWHERE));
		}
		
		if (empleado.getEmail() != null) {
			criteria.add(Restrictions.ilike("email",empleado.getEmail(), MatchMode.ANYWHERE));
		}		
		criteria.addOrder(Order.asc("nombre"));
		
		@SuppressWarnings("unchecked")
		List<Empleado> listEmpleado = criteria.list(); 
		
		session.close();
		
		return listEmpleado;
		
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
