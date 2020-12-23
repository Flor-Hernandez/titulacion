package com.fho.titulacion.app.service.implementations;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fho.titulacion.app.service.interfaces.ICodigoService;

@Service
public class CodigoService implements ICodigoService {

	private final Path root = Paths.get("compilados");
	@Override
	public String crearArchivo(String codigo) {
		// TODO Auto-generated method stub
		List<String> lines = Arrays.asList(codigo);
		 
		try {
			File err = new File(root.resolve("archivo.err").toString());
			File hex = new File(root.resolve("archivo.hex").toString());
			
			if(err.exists()) {
				err.delete();
			}
			
			if(hex.exists()) {
				hex.delete();
			}
			
			Files.write(this.root.resolve("archivo.c"), 
					    lines, 
					    StandardCharsets.UTF_8);
			return "creado";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}

	public String crearArchivoAsm(String codigo) {
		// TODO Auto-generated method stub
		List<String> lines = Arrays.asList(codigo);
		 
		try {
			File err = new File(root.resolve("archivoasm.err").toString());
			File hex = new File(root.resolve("archivoasm.hex").toString());
			
			if(err.exists()) {
				err.delete();
			}
			
			if(hex.exists()) {
				hex.delete();
			}
			
			Files.write(this.root.resolve("archivoasm.asm"), 
					    lines, 
					    StandardCharsets.UTF_8);
			return "creado";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
}
