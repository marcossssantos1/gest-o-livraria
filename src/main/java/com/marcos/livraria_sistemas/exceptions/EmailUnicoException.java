package com.marcos.livraria_sistemas.exceptions;

public class EmailUnicoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailUnicoException(String msg) {
		super(msg);
	}

}
