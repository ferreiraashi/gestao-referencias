package com.aranoua.gestao.referencias.dto.autor;

import com.aranoua.gestao.referencias.model.Afiliacao;
import com.aranoua.gestao.referencias.model.Autor;
import com.aranoua.gestao.referencias.repository.AfiliacaoRepository;
import com.aranoua.gestao.referencias.service.exception.ObjectNotFoundException;
import jakarta.validation.constraints.NotBlank;


public record AutorCreateDTO(
        @NotBlank(message = "nome não pode ser vazio.")
        String nome,
        @NotBlank(message = "referencia não pode ser vazio.")
        String referencia) {
    public Autor toAutorEntity(AfiliacaoRepository repository){
        Afiliacao afiliacao = repository.findByReferencia(referencia)
                .orElseThrow(() -> new ObjectNotFoundException("Afiliacao nao encontrada SIGLA:" + referencia));
        return new Autor(nome, afiliacao);
    }
}
