/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.UsuarioDTO;
import br.com.organizerooms.models.Receita;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.services.ReceitaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<Response> buscarTodasReceitas() {
        List<Receita> list = receitaService.buscarTodosReceitas();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping(path = "/menorPreco")
    public ResponseEntity<Response> buscarTodasReceitasOrderByPreco() {
        List<Receita> list = receitaService.buscarTodosReceitasOrderByPreco();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping(path = "/maiorPreco")
    public ResponseEntity<Response> buscarTodasReceitasOrderByPrecoDesc() {
        List<Receita> list = receitaService.buscarTodosReceitasOrderByPrecoDesc();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }

}
