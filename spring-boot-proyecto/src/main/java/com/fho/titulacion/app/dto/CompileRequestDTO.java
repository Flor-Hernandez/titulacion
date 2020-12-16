package com.fho.titulacion.app.dto;

import java.io.Serializable;

public class CompileRequestDTO implements Serializable {

	private String lenguaje;
	private String codigo;
	
	public CompileRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompileRequestDTO(String lenguaje, String codigo) {
		super();
		this.lenguaje = lenguaje;
		this.codigo = codigo;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	private static final long serialVersionUID = -937652981273498674L;


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
