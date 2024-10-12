package com.ifpe.gestaoalunos.servidor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {

	Servidor getReferenceById(Long i);

}
