/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.UsuarioDTO;
import br.com.organizerooms.models.Response;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.services.UsuarioServiceImpl;
import br.com.organizerooms.utils.SenhaUtils;
import java.util.stream.Collectors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Leandro Prado
 */
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    SenhaUtils senhaUtils;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> buscarTodosUsuarios() {
        List<Usuario> list = usuarioServiceImpl.buscarTodosUsuarios();
        List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> addUsuario(@RequestBody UsuarioDTO user) {
        Usuario usuario;
        usuario = new Usuario(user);
        UsuarioDTO userDTO = new UsuarioDTO(usuarioServiceImpl.addUsuario(usuario));
        Response response = new Response(userDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> atualizarUsuario(@RequestBody UsuarioDTO user) {
        Usuario usuario = new Usuario(user);
        UsuarioDTO userDTO = new UsuarioDTO(usuarioServiceImpl.addUsuario(usuario));
        Response response = new Response(userDTO);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public ResponseEntity<Response> deletarUsuario(@RequestBody UsuarioDTO user) {
        Usuario usuario = new Usuario(user);
        UsuarioDTO userDTO = new UsuarioDTO(usuarioServiceImpl.addUsuario(usuario));
        Response response = new Response(userDTO);
        return ResponseEntity.ok().body(response);
    }
    
    

}
