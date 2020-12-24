package com.fho.titulacion.app.response.entities;

import java.io.Serializable;

public class HexResponse implements Serializable{
  
	private byte[] hex;
	private boolean hasError;
	private String errorMessage;
	
	public HexResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HexResponse(byte[] hex, boolean hasError, String errorMessage) {
		super();
		this.hex = hex;
		this.hasError = hasError;
		this.errorMessage = errorMessage;
	}

	public byte[] getHex() {
		return hex;
	}

	public void setHex(byte[] hex) {
		this.hex = hex;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrotMessage(String errotMessage) {
		this.errorMessage = errorMessage;
	}

	private static final long serialVersionUID = 1L;
	
	
}
