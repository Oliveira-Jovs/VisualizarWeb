package com.ifpe.gestaoalunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.gestaoalunos.endereco.Endereco;
import com.ifpe.gestaoalunos.endereco.EnderecoDTO;
import com.ifpe.gestaoalunos.endereco.EnderecoService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {

		Endereco endereco = enderecoService.criarEndereco(enderecoDTO);

		return ResponseEntity.ok(endereco);
	}
}
