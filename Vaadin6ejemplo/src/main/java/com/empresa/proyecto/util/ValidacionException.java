package com.empresa.proyecto.util;

public class ValidacionException extends AlertaException {

	private static final long serialVersionUID = 8777366217361655207L;
	
	private static final String TITULO_DEFECTO = "Validación de Formulario";

	public ValidacionException(String codigoMensaje, Object[] args) {
		super(TITULO_DEFECTO, codigoMensaje, args);
	}
	
	public ValidacionException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}
	
	public ValidacionException(String codigoMensaje, Object[] args, Throwable cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}
	
}
