package com.aranoua.gestao.referencias.dto.autor;

import com.aranoua.gestao.referencias.dto.afiliacao.AfiliacaoDTO;
import com.aranoua.gestao.referencias.model.Autor;


public record AutorSimplesDTO(long id, String nome, AfiliacaoDTO afiliacao) {
    public static AutorSimplesDTO buildDTO(Autor autor) {
        return new AutorSimplesDTO(autor.getId(), autor.getNome(), AfiliacaoDTO.buildDTO(autor.getAfiliacao()));
    }
}
