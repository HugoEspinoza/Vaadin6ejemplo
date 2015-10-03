package com.empresa.proyecto.dao;

import java.util.List;

import com.empresa.proyecto.bean.Empleado;
import com.empresa.proyecto.util.AlertaException;

public interface EmpleadoDAO {

	public void crearEmpleado(Empleado empleado) throws AlertaException;
	
	public void actualizarEmpleado(Empleado empleado) throws AlertaException;
	
	public void eliminarEmpleado(Integer idEmpleado) throws AlertaException;
	
	public List<Empleado> listarEmpleados() throws AlertaException;
	
	public List<Empleado> buscarEmpleadosPorFiltros(Empleado empleado) throws AlertaException;
}
