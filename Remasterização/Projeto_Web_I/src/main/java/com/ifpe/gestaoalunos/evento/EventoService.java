package com.ifpe.gestaoalunos.evento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.gestaoalunos.servidor.Servidor;
import com.ifpe.gestaoalunos.servidor.ServidorRepository;

@Service
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private ServidorRepository servidorRepository;

	public Evento CriarEvento(EventoDTO eventoDTO) {
		Long idServidorFixo = 4L;
		Servidor servidor = servidorRepository.findById(idServidorFixo)
				.orElseThrow(() -> new RuntimeException("Servidor não encontrado"));

		Evento evento = new Evento();

		evento.setNome(eventoDTO.nome());
		evento.setDescricao(eventoDTO.descricao());
		evento.setData(eventoDTO.data());
		evento.setLocal(eventoDTO.local());
		evento.setTipo(eventoDTO.tipo());
		evento.setAtivo(true);

		evento.setServidor(servidor);
		return eventoRepository.save(evento);
	}
	
	 
	    public List<Evento> listarEventos() {
	        return eventoRepository.findAllByAtivoTrue();
	    }
	    
	    public void inativarEvento(Long id) {
	        Evento evento = eventoRepository.getReferenceById(id);
	        evento.inativar();
	        eventoRepository.save(evento); // Salvar a mudança de estado
	    }
}
