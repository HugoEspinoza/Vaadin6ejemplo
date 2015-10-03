package com.empresa.proyecto.vaadin;

import java.util.List;

import com.empresa.proyecto.bean.Opcion;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.MenuBar;

public class MyMenuBar extends MenuBar {

	private static final long serialVersionUID = 1427715714828794433L;
	
	public MyMenuItem addItem(String codigo, List<Opcion> opciones, String caption, Command command) {
		MyMenuItem newItem = new MyMenuItem(caption, null, command, codigo, opciones);
		getItems().add((MenuItem)newItem);
        requestRepaint();
		return newItem;
	}
	
	public class MyMenuItem extends MenuItem {
		
		private static final long serialVersionUID = 5969520527426095863L;
		
		private String codigo;
		private List<Opcion> acciones;

		public MyMenuItem(String caption, Resource icon,Command command, String codigo, List<Opcion> acciones) {
			super(caption, icon, command);
			this.codigo = codigo;
			this.acciones = acciones;
		}

		public String getCodigo() {
			return codigo;
		}

		public List<Opcion> getAcciones() {
			return acciones;
		}

		public MyMenuItem addItem(String codigo, List<Opcion> acciones, String caption, Command command) {
			
			MenuItem menuItem = super.addItem(caption, command);
			int index = getChildren().indexOf(menuItem);
			
			MyMenuItem newItem = new MyMenuItem(caption, null, command, codigo, acciones);
			newItem.setParent(this);
			getChildren().set(index, newItem);
			requestRepaint();
			return newItem;
		}

	}

}
