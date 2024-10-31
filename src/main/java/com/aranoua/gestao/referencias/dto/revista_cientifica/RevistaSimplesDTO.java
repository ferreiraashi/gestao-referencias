package com.aranoua.gestao.referencias.dto.revista_cientifica;

import com.aranoua.gestao.referencias.model.RevistaCientifica;

public record RevistaSimplesDTO(long id, String nome, String ISSN){
    public static RevistaSimplesDTO buildDTO(RevistaCientifica revista){
        return new RevistaSimplesDTO(revista.getId(), revista.getNome(), revista.getISSN());
    }
}
