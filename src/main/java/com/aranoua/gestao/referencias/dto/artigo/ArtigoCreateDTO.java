package com.aranoua.gestao.referencias.dto.artigo;


import com.aranoua.gestao.referencias.dto.autor.AutorCreateDTO;
import com.aranoua.gestao.referencias.model.Artigo;
import com.aranoua.gestao.referencias.model.Autor;
import com.aranoua.gestao.referencias.model.RevistaCientifica;
import com.aranoua.gestao.referencias.repository.AutorRepository;
import com.aranoua.gestao.referencias.repository.RevistaCientificaRepository;
import com.aranoua.gestao.referencias.service.exception.ObjectNotFoundException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public record ArtigoCreateDTO(
        @NotBlank(message = "titulo não pode ser vazio")
        String titulo,
        @NotBlank(message = "ano_publicacao não pode ser vazio")
        String ano_publicacao,
        @NotBlank(message = "revista não pode ser vazio")
        String revista,
        @NotNull(message = "deva haver pelo menos um autor não pode ser vazio ex: ['autor']")
        Set<AutorCreateDTO> autores
) {
    public Artigo toArtigoEntity(RevistaCientificaRepository revistaRepository, AutorRepository autorRepository){
        RevistaCientifica revista = encontrarRevista(revistaRepository);
        Set<Autor> listaAutores = encontrarAutores(autorRepository);
        Artigo artigo = new Artigo(titulo, ano_publicacao, revista, listaAutores);
        listaAutores.forEach(autor -> autor.getArtigos().add(artigo));
        return artigo;
    }

    public Artigo artigoAtualizado(Artigo artigoAntigo, RevistaCientificaRepository revistaRepository, AutorRepository autorRepository){
        Set<Autor> novalistaAutores = encontrarAutores(autorRepository);

        //Remove referencia do artigo nos autores removidos
        for(Autor autor: artigoAntigo.getAutores()){
            if(!novalistaAutores.contains(autor)){
                autor.getArtigos().remove(artigoAntigo);
            }
        }
        //Atualiza lista de autores
        artigoAntigo.setAutores(novalistaAutores);
        //adiciona referencia de artigo para artigos atuais
        for(Autor autor: artigoAntigo.getAutores()){
            autor.getArtigos().add(artigoAntigo);
        }

        artigoAntigo.setRevista(encontrarRevista(revistaRepository));
        artigoAntigo.setTitulo(titulo);
        artigoAntigo.setAnoPublicacao(ano_publicacao);
        return artigoAntigo;
    }

    private RevistaCientifica encontrarRevista(RevistaCientificaRepository repository){
        return  repository.findByNome(revista).orElseThrow(()->
                new ObjectNotFoundException("Revista não encontrada NOME: " + revista));
    }

    private Set<Autor> encontrarAutores(AutorRepository repository){
        return autores.stream()
                .map(autor ->
                        repository.findByNomeAndAfiliacao_Referencia(autor.nome(), autor.referencia()).orElseThrow(()->
                                new ObjectNotFoundException("Autor não encontrado Autor:"+ autor)))
                .collect(Collectors.toSet());
    }
}
