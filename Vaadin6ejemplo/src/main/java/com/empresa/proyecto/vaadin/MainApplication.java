package com.empresa.proyecto.vaadin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.empresa.proyecto.bean.Opcion;
import com.empresa.proyecto.bean.Usuario;
import com.empresa.proyecto.util.AlertaException;
import com.empresa.proyecto.util.Constante;
import com.empresa.proyecto.util.NotificacionException;
import com.vaadin.Application;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class MainApplication extends Application {

	private static final long serialVersionUID = 9085120770583847665L;
	private Window windowPrincipal;

	private MessageSource messageSource;
	
	public Window getWindowPrincipal() {
		return windowPrincipal;
	}

	@Override
	public void init() {

		ApplicationContext context = getApplicationContext();
		messageSource = (MessageSource) context.getBean("messageSource");
		setTheme("mytheme");
		windowPrincipal = new Window();
		setMainWindow(windowPrincipal);

		PanelLogin panelLogin = new PanelLogin();
		windowPrincipal.removeAllComponents();
		windowPrincipal.setCaption(Constante.NOMBRE_SISTEMA);
		windowPrincipal.addComponent(panelLogin);

	}

	private static ApplicationContext getApplicationContext() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		HttpSession session = request.getSession(false);
		return WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
	}
	
	@SuppressWarnings("deprecation")
	public void cargarPanelPrincipal(Usuario usuario, List<Opcion> listaOpciones) {
		
		windowPrincipal.removeAllComponents();

		PanelPrincipal panelPrincipal = new PanelPrincipal(usuario);
		panelPrincipal.prepararPanelPrincipal(listaOpciones);

		panelPrincipal.setWidth("100%");
		panelPrincipal.setHeight("100%");
		windowPrincipal.setCaption(Constante.NOMBRE_SISTEMA);
		windowPrincipal.getContent().setHeight("100%");
		windowPrincipal.getLayout().setMargin(false);
		windowPrincipal.setSizeFull();

		windowPrincipal.addComponent(panelPrincipal);

	}

	@Override
	public void terminalError(com.vaadin.terminal.Terminal.ErrorEvent event) {
		
		String defaultMessage = "Mensaje no especificado";

		if(event.getThrowable().getCause() instanceof NotificacionException){
			resolverNotificacionException((NotificacionException)event.getThrowable().getCause(), defaultMessage);
		}
		else if(event.getThrowable().getCause() instanceof AlertaException){
			resolverAlertaException((AlertaException) event.getThrowable().getCause(), defaultMessage);
		}
		else{
			resolverException(event.getThrowable().getCause(), defaultMessage);
			super.terminalError(event);
		}
	}
	
	private void resolverException(Throwable cause, String defaultMessage) {
		windowPrincipal.showNotification( "ERROR inesperado",
                messageSource.getMessage(
                		Constante.CODIGO_MENSAJE.ERROR_GENERICO, null, 
                		defaultMessage, this.getLocale()),
                Notification.TYPE_ERROR_MESSAGE);
	}
	
	private void resolverAlertaException(AlertaException alertaException, String defaultMessage) {
		
		String mensaje = messageSource.getMessage(
				alertaException.getCodigoMensaje(), 
				alertaException.getArgs(), 
        		defaultMessage, this.getLocale());
		
		windowPrincipal.showNotification(
				alertaException.getTitulo(),
				mensaje,
                Notification.TYPE_WARNING_MESSAGE);
	}
	
	private void resolverNotificacionException(NotificacionException notificacionException, String defaultMessage) {
		String mensaje = messageSource.getMessage(
        		notificacionException.getCodigoMensaje(), 
        		notificacionException.getArgs(), 
        		defaultMessage, this.getLocale());
		
		windowPrincipal.showNotification(
				notificacionException.getTitulo(),
				mensaje,
                Notification.TYPE_TRAY_NOTIFICATION);
	}

	public static HttpSession obtenerSesion() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request.getSession(false);
	}

}
