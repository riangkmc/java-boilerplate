package org.projeto.repository;

import org.projeto.model.entities.Teste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesteRepository extends JpaRepository<Teste,Long> {
}
