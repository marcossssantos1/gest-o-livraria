package com.marcos.livraria_sistemas.exceptions;

public class CamposInvalidosException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CamposInvalidosException(String msg) {
		super(msg);
	}

}
