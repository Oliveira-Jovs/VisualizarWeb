package com.ifpe.gestaoalunos.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.gestaoalunos.endereco.Endereco;
import com.ifpe.gestaoalunos.endereco.EnderecoRepository;

@Service
public class UsuarioService {
	
	 @Autowired
     private UsuarioRepository usuarioRepository;
	 
	 @Autowired
     private EnderecoRepository enderecoRepository;
	 
	 
	    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
	    	
	    	Endereco endereco = enderecoRepository.findById(usuarioDTO.idEndereco() )
	    			.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	    	
	        Usuario usuario = new Usuario();
	        usuario.setNome(usuarioDTO.nome());
	        usuario.setCpf(usuarioDTO.cpf());
	        usuario.setRg(usuarioDTO.rg());
	        usuario.setDataNascimento(usuarioDTO.dataNascimento());
	        usuario.setTelefone(usuarioDTO.telefone());
	        usuario.setEmail(usuarioDTO.email());
	        
	        usuario.setEndereco(endereco);
	        
	        return usuarioRepository.save(usuario);
	    }
}
