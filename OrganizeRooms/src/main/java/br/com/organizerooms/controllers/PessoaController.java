/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.PessoaDTO;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Response;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.organizerooms.services.PessoaService;
import br.com.organizerooms.utils.SenhaUtils;
import java.util.stream.Collectors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @Autowired
    SenhaUtils senhaUtils;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PESSOA')")
    public ResponseEntity<Response> buscarTodasPessoas() {
        List<Pessoa> list = pessoaService.buscarTodasPessoas();
        List<PessoaDTO> listDto = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PESSOA')")
    public ResponseEntity<Response> addPessoa(@RequestBody PessoaDTO pessoa) {
        Pessoa newPessoa = new Pessoa(pessoa);
        PessoaDTO pesDTO = new PessoaDTO(pessoaService.addPessoa(newPessoa));
        Response response = new Response(pesDTO);
        return ResponseEntity.ok().body(response);
    }

}
