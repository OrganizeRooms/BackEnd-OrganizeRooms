/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.context;

import java.sql.Date;

/**
 *
 * @author Pichau
 */
public class AgendamentoContext {
    
    private String idUnidade;
    private String lotacao;
    private String dataInicial;
    private String dataFinal;
    private String dataAgendamento;

    public AgendamentoContext() {
    }

    public AgendamentoContext(String idUnidade, String lotacao, String dataInicial, String dataFinal, String dataAgendamento) {
        this.idUnidade = idUnidade;
        this.lotacao = lotacao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.dataAgendamento = dataAgendamento;
    }
    

    public String getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(String idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    
    
}
