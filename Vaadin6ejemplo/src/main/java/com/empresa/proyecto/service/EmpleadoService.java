package com.empresa.proyecto.service;

import java.util.List;

import com.empresa.proyecto.bean.Empleado;
import com.empresa.proyecto.util.AlertaException;

public interface EmpleadoService {

	public void crearEmpleado(Empleado empleado) throws AlertaException;
	
	public void actualizarEmpleado(Empleado empleado) throws AlertaException; 
	
	public void eliminarEmpleado(Integer idEmpleado) throws AlertaException; 
	
	public List<Empleado> listarEmpleados() throws AlertaException;
	
	public List<Empleado> buscarEmpleadosPorFiltros(Empleado Empleado) throws AlertaException; 
	
}
