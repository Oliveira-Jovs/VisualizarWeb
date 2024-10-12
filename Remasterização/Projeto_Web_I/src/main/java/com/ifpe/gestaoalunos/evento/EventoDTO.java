package com.ifpe.gestaoalunos.evento;

public record EventoDTO(

		String nome, String descricao, String data, String local, String tipo
) {

	public EventoDTO(Evento evento) {
		this(
				evento.getNome(), 
				evento.getDescricao(),
				evento.getData(), 
				evento.getLocal(),
				evento.getTipo());
	}
}
