package br.com.organizerooms.repositorios;

import br.com.organizerooms.models.Participante;
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
public interface ParticipanteRepository extends JpaRepository <Participante, Long >{
   
    public List<Participante> findAllByOrderByParTipo(); 
    
}

