package com.ifpe.gestaoalunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.gestaoalunos.usuario.Usuario;
import com.ifpe.gestaoalunos.usuario.UsuarioDTO;
import com.ifpe.gestaoalunos.usuario.UsuarioService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;

	    @PostMapping
		public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
	        Usuario usuario = usuarioService.criarUsuario(usuarioDTO);
	        return ResponseEntity.ok(usuario);
}}