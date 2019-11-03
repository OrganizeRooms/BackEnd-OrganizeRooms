/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.dao;

import br.com.organizerooms.dto.SalaDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.Session;
import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aluno
 */

@Transactional
@Repository
public class AgendamentoDAO {
    @PersistenceContext	
    private EntityManager em;
    
    public List<SalaDTO> recuperaSala (Long idUnidade, Integer lotacao, Date dataInicial, Date dataFinal, Date dataAgendamento){
        List result = em.createNativeQuery("CALL FUNC_RECUPERA_SALAS_DISP(:idUnidade, :lotacao, :dataInicial, :dataFinal, :dataAgendamento)")
                .setParameter("idUnidade", idUnidade)
                .setParameter("lotacao", lotacao)
                .setParameter("dataInicial", dataInicial)
                .setParameter("dataFinal", dataFinal)
                .setParameter("dataAgendamento", dataAgendamento).getResultList();
        
        List<SalaDTO> salas = new ArrayList<>();
        
        for(int i=0; i<result.size(); i++){
	SalaDTO salaDTO = new SalaDTO();
        salaDTO.setSalaId((Long)result.get(0));
        salaDTO.setSalaNome((String)result.get(1));
        salaDTO.setSalaLotacao((Integer)result.get(2));
        salas.add(salaDTO);
	}
        
    return salas;            
        
    }
    
}
