/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.dao;

import br.com.organizerooms.dto.SalaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.Session;
import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.engine.spi.SessionFactoryImplementor;
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
    
    public List<SalaDTO> recuperaSala (String idUnidade, String lotacao, String dataInicial, String dataFinal, String dataAgendamento){
      List<SalaDTO> salas = new ArrayList<>();
      try {
            Connection sqlConnection  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/organizerooms", "root", "");
            Statement stmt = sqlConnection.createStatement();
            ResultSet rs = stmt.executeQuery("CALL PROC_RECUPERA_DISPONIVEIS("
                    + idUnidade + ","
                    + lotacao + ","
                    + "'" + dataInicial + "',"
                    + "'" + dataFinal + "',"
                    + "'" + dataAgendamento + "')"
            );
            
            while (rs.next()) {
            SalaDTO sala =  new SalaDTO();
            sala.setSalaId(rs.getLong(1));
            sala.setSalaNome(rs.getString(2));
            sala.setSalaLotacao(rs.getInt(3));
            salas.add(sala);
            }
            rs.close();
            stmt.close();
            }
        catch (Exception e) {
            e.printStackTrace();
         }
        
        return salas;            
        
    }
    
}
