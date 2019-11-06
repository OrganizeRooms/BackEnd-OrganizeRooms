/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.context;

import java.util.Date;
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
    private String idParticipante;
    private Date dataComDate;
    private String idSala;

    public AgendamentoContext() {}
    
    public AgendamentoContext(String idUnidade, String lotacao, String dataInicial, String dataFinal, String dataAgendamento, String idParticipante, Date dataComDate, String idSala) {
        this.idUnidade = idUnidade;
        this.lotacao = lotacao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.dataAgendamento = dataAgendamento;
        this.idParticipante = idParticipante;
        this.dataComDate = dataComDate;
        this.idSala = idSala;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public Date getDataComDate() {
        return dataComDate;
    }

    public void setDataComDate(Date dataComDate) {
        this.dataComDate = dataComDate;
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

    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }
 
    
}
