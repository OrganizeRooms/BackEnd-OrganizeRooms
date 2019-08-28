package br.com.organizerooms.services;

import br.com.organizerooms.models.EmailEnviado;
import br.com.organizerooms.repositorios.EmailEnviadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class EmailEnviadoServiceImpl {

    @Autowired
    private EmailEnviadoRepository emailEnviadoRepository;

    public EmailEnviado gravaEmailEnviado(EmailEnviado emailEnviado) {
        return this.emailEnviadoRepository.save(emailEnviado);
    }
}
