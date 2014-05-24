package org.centroescolar.exception;

public class CentroEscolarException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CentroEscolarException(){
		super();
	}
	
	public CentroEscolarException(String message, Throwable cause){
		super(message,cause);
	}
	
	public CentroEscolarException(String message){
		super(message);
	}
	
	public CentroEscolarException(Throwable cause){
		super(cause);
	}
}
