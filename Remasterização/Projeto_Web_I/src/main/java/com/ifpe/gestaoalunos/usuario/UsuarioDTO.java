package com.ifpe.gestaoalunos.usuario;

public record UsuarioDTO(String nome, String cpf, 
		String rg, String dataNascimento, String telefone, String email, Long idEndereco) {}

