package com.aranoua.gestao.referencias.dto.revista_cientifica;

import com.aranoua.gestao.referencias.model.RevistaCientifica;
import jakarta.validation.constraints.NotBlank;

public record RevistaCreateDTO(
        @NotBlank(message = "nome não pode ser vazio.")
        String nome,
        @NotBlank(message = "issn não pode ser vazio.")
        String ISSN){
    public RevistaCientifica toRevistaEntity(){
        return new RevistaCientifica(nome, ISSN);
    }
}
