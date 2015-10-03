package com.empresa.proyecto.util;

import com.vaadin.terminal.Terminal.ErrorEvent;

public class MyErrorEvent implements ErrorEvent{

	private static final long serialVersionUID = -7319901503470349026L;
	private Throwable throwable;
	
	public MyErrorEvent(BaseException baseException) {
		this.throwable = new Exception(baseException);
	}

	@Override
	public Throwable getThrowable() {
		return throwable;
	}
	
}
