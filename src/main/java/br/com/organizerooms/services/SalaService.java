package br.com.organizerooms.services;

import br.com.organizerooms.models.Sala;
import br.com.organizerooms.repositorios.SalaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eder Jean Dias
 */
@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;

    public List<Sala> buscarTodasSalas() {
        return this.salaRepository.findAllByOrderBySalaNome();
    }

    public void remover(Long id) {
        this.salaRepository.deleteById(id);
    }

    public Sala add(Sala sala) {
        return this.salaRepository.save(sala);
    }

    public Sala buscarSalaPorId(Long id) {
        return this.salaRepository.findById(id).get();
    }

}
