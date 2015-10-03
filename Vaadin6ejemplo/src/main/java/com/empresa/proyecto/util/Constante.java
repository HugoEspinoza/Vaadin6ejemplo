package com.empresa.proyecto.util;

public abstract class Constante {

	public static final String NOMBRE_EMPRESA = "CARLONCHO 2015 SAC";
	public static final String NOMBRE_SISTEMA = "Vaadin 6 App";
	public static final String VERSION = "Alpha 1.0.0";

	public static abstract class CODIGO_MENSAJE {

		public final static String ERROR_GENERICO = "error.generico";
		public final static String VALIDAR_CAMPOS_OBLIGATORIOS= "validar.campos.obligatorios";
		
		public final static String VALIDAR_TEXTBOX = "validar.textbox";
		public final static String VALIDAR_COMBOBOX = "validar.combobox";
		
		public final static String NO_USUARIO_REGISTRADO = "usuario.no.registrado";
		public final static String NO_USERNAME_REGISTRADO = "usuario.name.no.registrado";
		public final static String NO_OPCIONES_REGISTRADAS = "opcion.ninguna.registrada";
		
		public final static String VALIDAR_MENSAJE_GENERICO = "validar.mensaje.generico";
	}
	
	public static abstract class TITULO_FORMULARIO {

		public final static String LOGIN= "login";
//		public final static String PANEL_PRINCIPAL = "panel.principal";
//		public final static String PANEL_USUARIO = "panel.principal";
		
	}
	
	public static abstract class MENU {

		public final static String MENU_BARRA = "M";
		public final static String MENU_ITEM = "I";
		public final static String MANTS ="Manteminientos";
		public final static String MANT_EMPLEADOS ="Manteminiento de Empleados";
		public final static String MANT_ACCESOS ="Manteminiento de accesos";
		public final static String MANT_ACCESOS_PERFILES = "Por Perfiles";
		public final static String MANT_ACCESOS_FUNCIONALIDAD = "Por Funcionalidad";
		public final static String REPORTES ="Reportes";
		public final static String REPOR_GENERAL ="Reporte General";
	}
	
}
