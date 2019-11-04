package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.NotificacaoDTO;
import br.com.organizerooms.dto.PessoaDTO;
import br.com.organizerooms.models.Notificacao;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.utils.EnviaEmail;
import br.com.organizerooms.services.NotificacaoService;
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
 * @author Aluno
 */

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {
    
    @Autowired
    NotificacaoService notificacaoService;
    
    @Autowired
    EnviaEmail enviaEmail;
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Response> addNotificao(@RequestBody NotificacaoDTO notificacao) {
        Notificacao nnotificacao = new Notificacao(notificacao);
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO(notificacaoService.persiste(nnotificacao));
        Response response = new Response(notificacaoDTO);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarPorId(@PathVariable String id) {
        Notificacao notificacao = notificacaoService.buscaPorId(Long.parseLong(id));
        Response response = new Response(notificacao);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/pessoa")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Response> buscarPorPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        Notificacao notificacao = notificacaoService.buscaPorPessoa(pessoa);
        Response response = new Response(notificacao);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping  
    public ResponseEntity<Response> enviarEmail(@PathVariable String emailDestino, @PathVariable String subject, 
            @PathVariable String content) {
        Boolean b = enviaEmail.enviar(emailDestino, subject, content);
        Response response = new Response(b);
        return ResponseEntity.ok().body(response);
    }
}
