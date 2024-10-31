package com.aranoua.gestao.referencias.dto.afiliacao;

import com.aranoua.gestao.referencias.model.Afiliacao;

public record AfiliacaoDTO(long id, String nome, String sigla, String referencia) {
    public static AfiliacaoDTO buildDTO(Afiliacao afiliacao){
        return new AfiliacaoDTO(afiliacao.getId(), afiliacao.getNome(),afiliacao.getSigla(), afiliacao.getReferencia());
    }
}
