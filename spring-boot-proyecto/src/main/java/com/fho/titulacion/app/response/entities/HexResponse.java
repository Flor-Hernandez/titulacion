package com.fho.titulacion.app.response.entities;

import java.io.Serializable;

public class HexResponse implements Serializable{
  
	private byte[] hex;
	private String hexString;
	private boolean hasError;
	private String errorMessage;
	
	public HexResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public HexResponse(byte[] hex, String hexString, boolean hasError, String errorMessage) {
		super();
		this.hex = hex;
		this.hexString = hexString;
		this.hasError = hasError;
		this.errorMessage = errorMessage;
	}



	private static final long serialVersionUID = 1L;

	public byte[] getHex() {
		return hex;
	}



	public void setHex(byte[] hex) {
		this.hex = hex;
	}



	public String getHexString() {
		return hexString;
	}



	public void setHexString(String hexString) {
		this.hexString = hexString;
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



	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
