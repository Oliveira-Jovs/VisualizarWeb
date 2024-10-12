package com.ifpe.gestaoalunos.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.gestaoalunos.usuario.Usuario;
import com.ifpe.gestaoalunos.usuario.UsuarioRepository;

@Service
public class AlunoService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno CriarAluno(AlunoDTO alunoDTO) {
Usuario usuario = usuarioRepository.findById(alunoDTO.idUsuario())
.orElseThrow(() -> new RuntimeException("Usuário não encotrado")); 
		
		
		Aluno aluno = new Aluno();
		
		aluno.setUsuario(usuario);
		
		return alunoRepository.save(aluno);
	}
}
