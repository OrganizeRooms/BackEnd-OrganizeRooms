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
import br.com.organizerooms.services.UsuarioService;
import br.com.organizerooms.services.UsuarioServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    
    @Autowired
    ReceitaService receitaService;
    
    @Autowired
    UsuarioServiceImpl usuarioService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    @RequestMapping("/todos")
    public ResponseEntity<Response> buscarTodasReceitas() {
        List<Receita> list = receitaService.buscarTodosReceitas();
        Response response = new Response(list);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarReceitaPorUsuario(@PathVariable String id) {
        
        Optional<Usuario> user = usuarioService.buscarPorId(Long.parseLong(id));
        List<Receita> lista = receitaService.buscaReceitaPorUsuario(user.get());
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> cadastroDeReceita(@RequestBody Receita receita) {
        Receita recei = receitaService.cadastroDeReceita(receita);
        Response response = new Response(recei);
        return ResponseEntity.ok().body(response);
    }
}
