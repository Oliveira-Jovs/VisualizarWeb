package com.ifpe.gestaoalunos.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	    @Autowired
	    private EnderecoRepository enderecoRepository;

	    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
	    	
	    	
	        Endereco endereco = new Endereco();
	        
	        endereco.setEstado(enderecoDTO.estado());
	        endereco.setCidade(enderecoDTO.cidade());
	        endereco.setCep(enderecoDTO.cep());
	        endereco.setBairro(enderecoDTO.bairro());
	        endereco.setRua(enderecoDTO.rua());
	        endereco.setNumero(enderecoDTO.numero());
	        endereco.setComplemento(enderecoDTO.complemento());
	        
	        return enderecoRepository.save(endereco);
	        
	    }
	}


