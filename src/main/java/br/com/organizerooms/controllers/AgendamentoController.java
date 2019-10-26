package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.AgendamentoDTO;
import br.com.organizerooms.dto.PessoaDTO;
import br.com.organizerooms.dto.SalaDTO;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.models.Agendamento;
import br.com.organizerooms.models.Sala;
import br.com.organizerooms.models.Pessoa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.organizerooms.services.AgendamentoService;
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
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarTodosAgendamentos() {
        List<Agendamento> list = agendamentoService.buscarTodosAgendamentos();
        List<AgendamentoDTO> listDto = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Response> addOrUpdateAgendamento(@RequestBody AgendamentoDTO agendamento) {
        Agendamento newAgendamento = new Agendamento(agendamento);
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamentoService.add(newAgendamento));
        Response response = new Response(agendamentoDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarAgendamentoPorId(@PathVariable String id) {
        Agendamento lista = agendamentoService.buscarAgendamentoPorId(Long.parseLong(id));
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/pessoa")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarAgendamentoPorPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        List<Agendamento> lista = agendamentoService.buscaPorPessoa(pessoa);
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/pessoa")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarAgendamentoPorSala(@RequestBody SalaDTO salaDTO) {
        Sala sala = new Sala(salaDTO);
        List<Agendamento> lista = agendamentoService.buscaPorSala(sala);
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }

}

