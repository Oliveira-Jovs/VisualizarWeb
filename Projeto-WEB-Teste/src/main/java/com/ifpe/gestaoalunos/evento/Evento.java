package com.ifpe.gestaoalunos.evento;

import com.ifpe.gestaoalunos.servidor.Servidor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evento")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private String data;
	private String local;
	
	@ManyToOne
	@JoinColumn(name = "idServidor")
	private Servidor servidor;
}
