package br.com.organizerooms.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.organizerooms.models.Venda;
import br.com.organizerooms.models.Usuario;
import java.util.List;

@Repository
@Transactional(readOnly = true )
public interface VendaRepository extends JpaRepository <Venda, Long >{
 
}
