package com.aranoua.gestao.referencias.repository;

import com.aranoua.gestao.referencias.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
