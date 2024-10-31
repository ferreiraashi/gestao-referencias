package com.aranoua.gestao.referencias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MensagemException {
    private String codigo;
    private String mensagem;
}
