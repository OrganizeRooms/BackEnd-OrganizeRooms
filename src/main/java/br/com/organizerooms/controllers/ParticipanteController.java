package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.ParticipanteDTO;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.models.Participante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.organizerooms.services.ParticipanteService;
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
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    ParticipanteService  participanteService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarTodosParticipantes() {
        List<Participante> list = participanteService.buscarTodosParticipantes();
        List<ParticipanteDTO> listDto = list.stream().map(obj -> new ParticipanteDTO(obj)).collect(Collectors.toList());
        Response response = new Response(listDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Response> addOrUpdateParticipante(@RequestBody ParticipanteDTO participante) {
        Participante newParticipante = new Participante(participante);
        ParticipanteDTO participanteDTO = new ParticipanteDTO(participanteService.add(newParticipante));
        Response response = new Response(participanteDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarParticipantePorId(@PathVariable String id) {
        Participante lista = participanteService.buscarParticipantePorId(Long.parseLong(id));
        Response response = new Response(lista);
        return ResponseEntity.ok().body(response);
    }

}


