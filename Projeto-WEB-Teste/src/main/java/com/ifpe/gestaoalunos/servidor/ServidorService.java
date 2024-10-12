package com.ifpe.gestaoalunos.servidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.gestaoalunos.usuario.Usuario;
import com.ifpe.gestaoalunos.usuario.UsuarioRepository;
@Service
public class ServidorService {
	 @Autowired
	    private ServidorRepository servidorRepository;

	    @Autowired
	    private UsuarioRepository usuarioRepository;

	    public Servidor CriarServidor(ServidorDTO servidorDTO) {
	    	
	        Usuario usuario = usuarioRepository.findById(servidorDTO.idUsuario())
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	        Servidor servidor = new Servidor();
	        servidor.setSiape(servidorDTO.siape());
	        servidor.setCargo(servidorDTO.cargo());
	        
	        servidor.setUsuario(usuario);

	        return servidorRepository.save(servidor);
	    }
}
