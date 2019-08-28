package br.com.organizerooms.controllers;

import br.com.organizerooms.dto.EnviaEmailDTO;
import br.com.organizerooms.models.Response;
import br.com.organizerooms.services.UsuarioServiceImpl;
import br.com.blucake.api.utils.EnviaEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas Jansen
 */
@RestController
@RequestMapping("/enviaEmail")
public class EnviaEmailController {

    @Autowired
    EnviaEmail enviaEmail;

    @PostMapping  
    public ResponseEntity<Response> enviarEmail(@RequestBody EnviaEmailDTO email) {
        Boolean b = enviaEmail.enviar(email);
        Response response = new Response(b);
        return ResponseEntity.ok().body(response);
    }
}
