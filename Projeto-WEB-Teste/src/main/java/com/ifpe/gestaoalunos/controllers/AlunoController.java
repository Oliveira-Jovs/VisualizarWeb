package com.ifpe.gestaoalunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.gestaoalunos.aluno.Aluno;
import com.ifpe.gestaoalunos.aluno.AlunoDTO;
import com.ifpe.gestaoalunos.aluno.AlunoService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	
	@Autowired
	private AlunoService alunoService;
	
	
	@PostMapping
	public ResponseEntity<Aluno> criarAluno(@RequestBody AlunoDTO alunoDTO) {
		Aluno aluno = alunoService.CriarAluno(alunoDTO);
		return ResponseEntity.ok(aluno);
	}
	

}
