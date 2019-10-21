package br.com.organizerooms.repositorios;

import br.com.organizerooms.models.Agendamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eder Jean Dias
 */
@Repository
@Transactional(readOnly = true )
public interface AgendamentoRepository extends JpaRepository <Agendamento, Long >{
   
    public List<Agendamento> findAllByOrderByAgeDescricao(); 
    
}

