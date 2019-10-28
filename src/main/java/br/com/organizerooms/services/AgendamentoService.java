package br.com.organizerooms.services;

import br.com.organizerooms.models.Agendamento;
import br.com.organizerooms.models.Sala;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.repositorios.AgendamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eder Jean Dias
 */
@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public List<Agendamento> buscarTodosAgendamentos() {
        return this.agendamentoRepository.findAllByOrderByAgeDescricao();
    }

    public void remover(Long id) {
        this.agendamentoRepository.deleteById(id);
    }

    public Agendamento add(Agendamento agendamento) {
        return this.agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarAgendamentoPorId(Long id) {
        return this.agendamentoRepository.findById(id).get();
    }
    
    public List<Agendamento> buscaPorPessoa (Pessoa pessoa){
        return this.agendamentoRepository.findByAgePesResponsavel(pessoa);
    };
    
    public List<Agendamento> buscaPorSala (Sala sala){
        return this.agendamentoRepository.findByAgeSala(sala);
    };

}

