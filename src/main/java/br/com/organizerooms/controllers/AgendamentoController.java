package br.com.organizerooms.controllers;

import br.com.organizerooms.dao.AgendamentoDAO;
import br.com.organizerooms.dto.AgendamentoDTO;
import br.com.organizerooms.context.AgendamentoContext;
import br.com.organizerooms.dto.EquipamentoDTO;
import br.com.organizerooms.dto.PessoaDTO;
import br.com.organizerooms.dto.SalaDTO;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.models.Agendamento;
import br.com.organizerooms.models.Participante;
import br.com.organizerooms.models.Sala;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.repositorios.ParticipanteRepository;
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

    @Autowired
    ParticipanteRepository participanteRepository;
    
    @Autowired
    AgendamentoDAO agendamentoDAO;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarTodosAgendamentos() {
        List<Agendamento> list = agendamentoService.buscarTodosAgendamentos();
        List<AgendamentoDTO> listDto = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> adicionarAgendamento(@RequestBody AgendamentoDTO agendamento) {
        Agendamento newAgendamento = new Agendamento(agendamento);
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamentoService.add(newAgendamento));

        if (!newAgendamento.getParticipantes().isEmpty()) {
            List<Participante> parts = newAgendamento.getParticipantes();

            int cont = 0;
            while (cont < parts.size()) {
                Participante part = parts.get(cont);

                part.setParAgendamento(new Agendamento(agendamentoDTO));
                participanteRepository.save(part);
                cont++;
            }
        }

        Response response = new Response(agendamentoDTO);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/atualizar")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> atualizarAgendamento(@RequestBody AgendamentoDTO agendamento) {
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
    
    @PostMapping("/salasdisp")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarSalasDisponiveis(@RequestBody AgendamentoContext ctx) {
        List<SalaDTO> salas = agendamentoDAO.recuperaSala(ctx.getIdUnidade(), ctx.getLotacao(), ctx.getDataInicial(), ctx.getDataFinal(), ctx.getDataAgendamento());
        Response response = new Response(salas);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/sala")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarAgendamentoPorSala(@RequestBody SalaDTO salaDTO) {
        Sala sala = new Sala(salaDTO);
        List<Agendamento> lista = agendamentoService.buscaPorSala(sala);
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/participante")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarAgendamentoPorParticipanteEData(@RequestBody AgendamentoContext ctx) {
        List<Agendamento> ag = agendamentoService.buscaPorPaticipanteEData(Long.parseLong(ctx.getIdParticipante()), ctx.getDataComDate());
        Response response = new Response(ag);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("/salas")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarAgendamentoPorSalaEData(@RequestBody AgendamentoContext ctx) {
        List<Agendamento> ag = agendamentoService.buscaPorSalaEData(Long.parseLong(ctx.getIdSala()), ctx.getDataComDate());
        Response response = new Response(ag);
        return ResponseEntity.ok().body(response);
    }
    
}
