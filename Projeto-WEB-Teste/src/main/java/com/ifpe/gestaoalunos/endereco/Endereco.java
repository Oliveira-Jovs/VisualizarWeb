package com.ifpe.gestaoalunos.endereco;

import java.util.List;

import com.ifpe.gestaoalunos.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Endereco")
@Entity(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Endereco {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	
	
/*
	public Endereco(EnderecoDTO enderecoDTO) {
		this.estado = enderecoDTO.estado();
		this.cidade = enderecoDTO.cidade();
		this.cep = enderecoDTO.cep();
		this.bairro = enderecoDTO.bairro();
		this.rua = enderecoDTO.rua();
		this.numero = enderecoDTO.numero();
		this.complemento = enderecoDTO.complemento();
	}

*/

	@OneToMany(mappedBy = "endereco")
    private List<Usuario> usuarios;


}