package com.ifpe.gestaoalunos.evento;

public record EventoDTO(
		
		String nome,
		String descricao,
		String data,
		String local,
		Long idServidor
		
		) {

}
