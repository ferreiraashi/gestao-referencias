package com.aranoua.gestao.referencias.repository;

import com.aranoua.gestao.referencias.model.Afiliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfiliacaoRepository extends JpaRepository<Afiliacao, Long> {
    Optional<Afiliacao> findByNome(String nome);
    Optional<Afiliacao> findByReferencia(String referencia);
}
