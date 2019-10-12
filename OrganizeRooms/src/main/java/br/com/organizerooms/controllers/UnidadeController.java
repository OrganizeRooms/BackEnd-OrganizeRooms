/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.UnidadeDTO;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.models.Unidade;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.organizerooms.services.UnidadeService;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    UnidadeService unidadeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PESSOA')")
    public ResponseEntity<Response> buscarTodasUnidades() {
        List<Unidade> list = unidadeService.buscarTodasUnidades();
        List<UnidadeDTO> listDto = list.stream().map(obj -> new UnidadeDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PESSOA')")
    public ResponseEntity<Response> addOrUpdateUnidade(@RequestBody UnidadeDTO unidade) {
        Unidade newUnidade = new Unidade(unidade);
        UnidadeDTO uniDTO = new UnidadeDTO(unidadeService.addUnidade(newUnidade));
        Response response = new Response(uniDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PESSOA')")
    public ResponseEntity<Response> buscarUnidadePorId(@PathVariable String id) {

        Optional<Unidade> lista = unidadeService.buscarUnidadePorId(Long.parseLong(id));
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }

}
