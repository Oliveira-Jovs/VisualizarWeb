package com.ifpe.gestaoalunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.gestaoalunos.evento.Evento;
import com.ifpe.gestaoalunos.evento.EventoDTO;
import com.ifpe.gestaoalunos.evento.EventoService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@PostMapping
	public ResponseEntity<Evento> criarEvento(@RequestBody EventoDTO eventoDTO){
		
		Evento evento = eventoService.CriarEvento(eventoDTO);
		
		return ResponseEntity.ok(evento);
		
	}
	
}
