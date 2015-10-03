package com.empresa.proyecto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.proyecto.bean.Empleado;
import com.empresa.proyecto.dao.EmpleadoDAO;
import com.empresa.proyecto.service.EmpleadoService;
import com.empresa.proyecto.util.AlertaException;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private EmpleadoDAO empleadoDAO;
	
	@Override
	public void crearEmpleado(Empleado empleado) throws AlertaException {

		empleadoDAO.crearEmpleado(empleado);
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) throws AlertaException {
		
		empleadoDAO.actualizarEmpleado(empleado);
	}

	@Override
	public void eliminarEmpleado(Integer idEmpleado) throws AlertaException {

		empleadoDAO.eliminarEmpleado(idEmpleado);
	}

	@Override
	public List<Empleado> listarEmpleados() throws AlertaException {

		List<Empleado> listaEmpleado = empleadoDAO.listarEmpleados();
		return listaEmpleado;
	}

	
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}

	@Override
	public List<Empleado> buscarEmpleadosPorFiltros(Empleado Empleado) throws AlertaException {

		List<Empleado> listaEmpleado = empleadoDAO.buscarEmpleadosPorFiltros(Empleado);
		
		return listaEmpleado;
	}

}
