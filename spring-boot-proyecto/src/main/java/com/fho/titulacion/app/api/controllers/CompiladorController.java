package com.fho.titulacion.app.api.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;

import com.fho.titulacion.app.dto.CompileRequestDTO;
import com.fho.titulacion.app.service.implementations.CodigoService;

@RestController
@RequestMapping("/api/compilar")
public class CompiladorController {

	private final Path root = Paths.get("compilados");
	@Autowired
	CodigoService codigoService;
	
   @PostMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
   @RequestMapping("/c")
   public @ResponseBody byte[] compilar(@RequestBody CompileRequestDTO request) {
	   
	  String resultado =codigoService.crearArchivo(request.getCodigo());
	  
	  if(resultado == "creado" ) {
		 String command = "CCSC +FM +FH C:\\Users\\florh\\git\\titulacion\\spring-boot-proyecto\\compilados\\archivo.c";
	     try {
	    	 Thread.sleep(2000);
			Runtime.getRuntime().exec(command);
			Thread.sleep(2000);
		    File hex = new File(root.resolve("archivo.hex").toString());
		    
		    if(hex.exists() && hex.canRead()) {
		    	Path ruta = root.resolve("archivo.hex");//.toAbsolutePath().toString();
		    	byte[] res = Files.readAllBytes(ruta);
		    	return res;
		    }
		    
	     } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
	     
	     
	  }
	return null;
	  
}
   
   @PostMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
   @RequestMapping("/asm")
   public @ResponseBody byte[] compilarAsm(@RequestBody CompileRequestDTO request) {
	   
	  String resultado =codigoService.crearArchivoAsm(request.getCodigo());
	  
	  if(resultado == "creado" ) {
		 String command = "C:\\Program Files (x86)\\Microchip\\MPASM Suite\\MPASMWIN.exe /e /l C:\\Users\\florh\\git\\titulacion\\spring-boot-proyecto\\compilados\\archivoasm";
	     try {
	    	 Thread.sleep(2000);
			Runtime.getRuntime().exec(command);
			Thread.sleep(2000);
		    File hex = new File(root.resolve("archivoasm.hex").toString());
		    
		    if(hex.exists() && hex.canRead()) {
		    	Path ruta = root.resolve("archivoasm.hex");//.toAbsolutePath().toString();
		    	byte[] res = Files.readAllBytes(ruta);
		    	return res;
		    }
		    
	     } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
	     
	     
	  }
	return null;
	  
}
   
}
