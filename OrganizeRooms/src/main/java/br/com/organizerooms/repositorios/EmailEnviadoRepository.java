package br.com.organizerooms.repositorios;

import br.com.organizerooms.models.EmailEnviado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lucas
 */
@Repository
@Transactional(readOnly = true)
public interface EmailEnviadoRepository extends JpaRepository<EmailEnviado, Long> {
    
}
