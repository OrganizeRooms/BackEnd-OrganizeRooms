package br.com.organizerooms.repositorios;

import br.com.organizerooms.models.Sala;
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
public interface SalaRepository extends JpaRepository <Sala, Long >{
   
    public List<Sala> findAllByOrderBySalaNome(); 
    
}

