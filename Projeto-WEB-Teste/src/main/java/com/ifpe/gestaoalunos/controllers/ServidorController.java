package com.ifpe.gestaoalunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.gestaoalunos.servidor.Servidor;
import com.ifpe.gestaoalunos.servidor.ServidorDTO;
import com.ifpe.gestaoalunos.servidor.ServidorService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/servidores")
public class ServidorController {
	
	   @Autowired
		private ServidorService servidorService;

	    @PostMapping
	    public ResponseEntity<Servidor> criarServidor(@RequestBody ServidorDTO servidorDTO) {	    	
	        Servidor servidor = servidorService.CriarServidor(servidorDTO);
	        return ResponseEntity.ok(servidor);
	    }
}
