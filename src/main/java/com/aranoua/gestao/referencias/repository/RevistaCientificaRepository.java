package com.aranoua.gestao.referencias.repository;

import com.aranoua.gestao.referencias.model.RevistaCientifica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RevistaCientificaRepository extends JpaRepository<RevistaCientifica, Long> {
    Optional<RevistaCientifica> findByNome(String nome);
}
