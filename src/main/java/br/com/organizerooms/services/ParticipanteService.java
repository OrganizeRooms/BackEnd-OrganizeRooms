package br.com.organizerooms.services;

import br.com.organizerooms.models.Participante;
import br.com.organizerooms.repositorios.ParticipanteRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eder Jean Dias
 */
@Service
public class ParticipanteService {
    
    @Autowired
    ParticipanteRepository participanteRepository;

    public List<Participante> buscarTodosParticipantes() {
        return this.participanteRepository.findAllByOrderByParTipo();
    }

    public void remover(Long id) {
        this.participanteRepository.deleteById(id);
    }

    public Participante add(Participante participante) {
        return this.participanteRepository.save(participante);
    }

    public Participante buscarParticipantePorId(Long id) {
        return this.participanteRepository.findById(id).get();
    }
}
