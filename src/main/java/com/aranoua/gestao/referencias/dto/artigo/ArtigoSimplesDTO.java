package com.aranoua.gestao.referencias.dto.artigo;


import com.aranoua.gestao.referencias.model.Artigo;


public record ArtigoSimplesDTO(long id, String titulo, String ano_publicacao, String revista) {
    public static ArtigoSimplesDTO buildDTO(Artigo artigo){
        return new ArtigoSimplesDTO(artigo.getId(), artigo.getTitulo(), artigo.getAnoPublicacao(), artigo.getRevista().getNome() );
    }
}
