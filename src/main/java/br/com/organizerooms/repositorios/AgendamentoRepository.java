package br.com.organizerooms.repositorios;

import br.com.organizerooms.models.Agendamento;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Sala;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eder Jean Dias
 */
@Repository
@Transactional(readOnly = true)
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    public List<Agendamento> findAllByOrderByAgeDescricao();

    public List<Agendamento> findByAgePesResponsavel(Pessoa pessoa);

    public List<Agendamento> findByAgeSala(Sala sala);

    @Query("select a.ageId, a.ageAssunto, a.ageData, a.ageDescricao, a.ageHoraInicio, a.ageHoraFim, a.ageStatus from Agendamento a "
            + "INNER JOIN Participante p ON a.ageId = p.parAgendamento "
            + "WHERE p.parPessoa = ?1 and a.ageData = ?2 and a.ageStatus in ('AGENDADO', 'EM ANDAMENTO')")
    /*@Query("select a from agendamento a INNER JOIN a.participante p INNER JOIN p.parPessoa pp WHERE pp.pesId = ?1 and a.ageData = ?2 and a.ageStatus = 'AGENDADO'")*/
    public List<Agendamento> recuperaAgendamentosParticipante(Long idParticipante, Date dataAgrupamento);

    /*@Query("select a from Agendamento a INNER JOIN a.ageSala s where s.salaId = ?1 a.ageData = ?2 and a.ageStatus = 'AGENDADO'")
    public List<Agendamento> recuperaAgendamentoSala(Long idSala, Date dataAgrupamento);*/

}
