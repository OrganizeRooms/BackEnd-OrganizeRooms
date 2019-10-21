package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.SalaDTO;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.models.Sala;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.organizerooms.services.SalaService;
import java.util.stream.Collectors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Eder Jean Dias
 */
@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    SalaService salaService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarTodasSalas() {
        List<Sala> list = salaService.buscarTodasSalas();
        List<SalaDTO> listDto = list.stream().map(obj -> new SalaDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Response> addOrUpdateSala(@RequestBody SalaDTO sala) {
        Sala newSala = new Sala(sala);
        SalaDTO salaDTO = new SalaDTO(salaService.add(newSala));
        Response response = new Response(salaDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarSalaPorId(@PathVariable String id) {

        Sala lista = salaService.buscarSalaPorId(Long.parseLong(id));
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }

}
