package com.ifpe.gestaoalunos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.gestaoalunos.evento.Evento;
import com.ifpe.gestaoalunos.evento.EventoDTO;
import com.ifpe.gestaoalunos.evento.EventoService;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/evento")
//@CrossOrigin(origins = "*")

public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@PostMapping
	public ResponseEntity<Evento> criarEvento(@RequestBody EventoDTO eventoDTO){
		
		Evento evento = eventoService.CriarEvento(eventoDTO);
		
		return ResponseEntity.ok(evento);
		
	}
	
	@GetMapping
    public List<EventoDTO> listar() {
        return eventoService.listarEventos().stream().map(EventoDTO::new).toList();
    }
	
	@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        eventoService.inativarEvento(id);
        return ResponseEntity.noContent().build();
    }
	
	
}
