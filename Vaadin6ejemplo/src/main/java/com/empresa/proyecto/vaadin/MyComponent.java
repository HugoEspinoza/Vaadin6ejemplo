package com.empresa.proyecto.vaadin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.commons.lang.StringUtils;

import com.empresa.proyecto.bean.Opcion;
import com.vaadin.ui.CustomComponent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.ui.AbstractTextField;


public abstract class MyComponent extends CustomComponent {

	private static final long serialVersionUID = -7839153867932607584L;

	
	@SuppressWarnings("unused")
	private List<Opcion> acciones;
	private String height;
	public boolean modificaAltura = false;
	
	public abstract void postConstruccion();
	
	public MyComponent(){
	}
	
	public MyComponent(List<Opcion> acciones, String height){
		this.acciones = acciones;
		this.height = height;
	}
	
	@Override
	public void attach() {
		super.attach();
		setHeight(height);
	}
	
	public static String getString(AbstractTextField txtInput){
		String valor=(String)txtInput.getValue();
		if(valor!=null){
			return valor.trim();
		}
		return null;
	}
	public static String getString(TextChangeEvent txtInput){
		String valor=txtInput.getText();
		if(valor!=null){
			return valor;
		}
		return null;
	}
	public static Integer getInteger(AbstractTextField txtInput){
		String valor=(String)txtInput.getValue();
		if(valor!=null&&!StringUtils.isEmpty(valor)){
			if(StringUtils.isNumeric(valor))
			return Integer.parseInt(valor);
		}
		return null;
	}
	public static Integer getInteger(TextChangeEvent txtInput){
		String valor=txtInput.getText();
		if(valor!=null&&!StringUtils.isEmpty(valor)){
			if(StringUtils.isNumeric(valor))
			return Integer.parseInt(valor);
		}
		return null;
	}
	public static Long getLong(AbstractTextField txtInput){
		String valor=(String)txtInput.getValue();
		if(valor!=null&&!StringUtils.isEmpty(valor)){
			if(StringUtils.isNumeric(valor))
			return Long.parseLong(valor);
		}
		return null;
	}
	public static Long getLong(TextChangeEvent txtInput){
		String valor=txtInput.getText();
		if(valor!=null&&!StringUtils.isEmpty(valor)){
			if(StringUtils.isNumeric(valor))
			return Long.parseLong(valor);
		}
		return null;
	}
	
	protected void sessionSetAttribute(String llave, Object value) {
		if(RequestContextHolder.getRequestAttributes()!=null){
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			HttpSession session = request.getSession(false);
			if(session != null)
			{
				session.setAttribute(llave, value);
			}	
		}		
	}
}
