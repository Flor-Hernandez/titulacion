package com.fho.titulacion.app.api.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fho.titulacion.app.dto.CompileRequestDTO;
import com.fho.titulacion.app.service.implementations.CodigoService;

@RestController
@RequestMapping("/api/compilar")
public class CompiladorController {

	@Autowired
	CodigoService codigoService;
	
   @PostMapping
   public ResponseEntity<String> compilar(@RequestBody CompileRequestDTO request) {
	   
	  String resultado = codigoService.crearArchivo(request.getCodigo());
	   return ResponseEntity.ok(resultado);
	   
   }
 
}
