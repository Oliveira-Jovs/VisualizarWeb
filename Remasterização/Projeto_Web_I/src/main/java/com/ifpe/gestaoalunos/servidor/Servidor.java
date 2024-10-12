package com.ifpe.gestaoalunos.servidor;

import com.ifpe.gestaoalunos.usuario.Usuario;

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
@Table(name = "servidor")


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Servidor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
	
	private String siape; 
	private String cargo;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

	
	

}
