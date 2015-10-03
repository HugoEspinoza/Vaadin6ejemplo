package com.empresa.proyecto.util;

public class AlertaException extends BaseException{

	private static final long serialVersionUID = 5388565969101251519L;

//	private String campoForm;
	
	public AlertaException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}
	
	
	public AlertaException(String titulo, String codigoMensaje, Object[] args, Throwable cause) {
		super(titulo, codigoMensaje, args, cause);
	}
//	
//	public AlertaException(String titulo, String codigoMensaje, String campoForm, Object[] args) {
//		super(titulo, codigoMensaje, args);
//		this.campoForm = campoForm;
//	}


//	public String getCampoForm() {
//		return campoForm;
//	}
//
//
//	public void setCampoForm(String campoForm) {
//		this.campoForm = campoForm;
//	}
	
}
