package com.empresa.proyecto.util;

public abstract class NotificacionException extends BaseException{

	private static final long serialVersionUID = 728113752273375121L;

	public NotificacionException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}
}
