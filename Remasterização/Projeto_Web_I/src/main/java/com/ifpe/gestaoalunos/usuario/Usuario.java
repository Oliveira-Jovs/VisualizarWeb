package com.ifpe.gestaoalunos.usuario;

import java.util.List;

import com.ifpe.gestaoalunos.endereco.Endereco;
import com.ifpe.gestaoalunos.servidor.Servidor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Usuario")


@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@EqualsAndHashCode(of = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String telefone;
	private String email;
	

	@ManyToOne
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "usuario")
	private List<Servidor> servidores;
	
	
	
	
	

}
