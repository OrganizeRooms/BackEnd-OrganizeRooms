/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.models;

import br.com.organizerooms.dto.AgendamentoDTO;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Eder Jean Dias
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendamentoId;
    
    @Column
    private String ageAssunto;
    
    @Column
    private String ageDescricao;
    
    @Column
    private String ageStatus;
    
    @Column
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date ageData;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ageHoraInicio;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ageHoraFim;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ageDtCadastro;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ageDtAtualizacao;
    
    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala salaId;
    
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pesIdResponsavel;
    
    @Column
    private Long agePesCadastro;

    @Column
    private Long agePesAtualizacao;

    public Long getAgePesCadastro() {
        return agePesCadastro;
    }

    public void setAgePesCadastro(Long agePesCadastro) {
        this.agePesCadastro = agePesCadastro;
    }

    public Long getAgePesAtualizacao() {
        return agePesAtualizacao;
    }

    public void setAgePesAtualizacao(Long agePesAtualizacao) {
        this.agePesAtualizacao = agePesAtualizacao;
    }

    public Agendamento() {
    }

    public Agendamento(Long agendamentoId, String ageAssunto, String ageDescricao, String ageStatus, Date ageData, 
            Time ageHoraInicio, Time ageHoraFim, Date ageDtCadastro, Date ageDtAtualizacao, Sala salaId, 
            Pessoa pesIdResponsavel, Long agePesCadastro, Long agePesAtualizacao) {
        this.agendamentoId = agendamentoId;
        this.ageAssunto = ageAssunto;
        this.ageDescricao = ageDescricao;
        this.ageStatus = ageStatus;
        this.ageData = ageData;
        this.ageHoraInicio = ageHoraInicio;
        this.ageHoraFim = ageHoraFim;
        this.ageDtCadastro = ageDtCadastro;
        this.ageDtAtualizacao = ageDtAtualizacao;
        this.salaId = salaId;
        this.pesIdResponsavel = pesIdResponsavel;
        this.agePesCadastro = agePesCadastro;
        this.agePesAtualizacao = agePesAtualizacao;
    }
    
    public Agendamento(AgendamentoDTO obj) {
        this.agendamentoId = obj.getAgendamentoId();
        this.ageAssunto = obj.getAgeAssunto();
        this.ageDescricao = obj.getAgeDescricao();
        this.ageStatus = obj.getAgeStatus();
        this.ageData = obj.getAgeData();
        this.ageHoraInicio = obj.getAgeHoraInicio();
        this.ageHoraFim = obj.getAgeHoraFim();
        this.ageDtCadastro = obj.getAgeDtCadastro();
        this.ageDtAtualizacao = obj.getAgeDtAtualizacao();
        this.salaId = obj.getSalaId();
        this.pesIdResponsavel = obj.getPesIdResponsavel();
        this.agePesCadastro = obj.getAgePesCadastro();
        this.agePesAtualizacao = obj.getAgePesAtualizacao();
    }
    
    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public String getAgeAssunto() {
        return ageAssunto;
    }

    public void setAgeAssunto(String ageAssunto) {
        this.ageAssunto = ageAssunto;
    }

    public String getAgeDescricao() {
        return ageDescricao;
    }

    public void setAgeDescricao(String ageDescricao) {
        this.ageDescricao = ageDescricao;
    }

    public String getAgeStatus() {
        return ageStatus;
    }

    public void setAgeStatus(String ageStatus) {
        this.ageStatus = ageStatus;
    }

    public Date getAgeData() {
        return ageData;
    }

    public void setAgeData(Date ageData) {
        this.ageData = ageData;
    }

    public Date getAgeHoraInicio() {
        return ageHoraInicio;
    }

    public void setAgeHoraInicio(Time ageHoraInicio) {
        this.ageHoraInicio = ageHoraInicio;
    }

    public Date getAgeHoraFim() {
        return ageHoraFim;
    }

    public void setAgeHoraFim(Time ageHoraFim) {
        this.ageHoraFim = ageHoraFim;
    }

    public Date getAgeDtCadastro() {
        return ageDtCadastro;
    }

    public void setAgeDtCadastro(Date ageDtCadastro) {
        this.ageDtCadastro = ageDtCadastro;
    }

    public Date getAgeDtAtualizacao() {
        return ageDtAtualizacao;
    }

    public void setAgeDtAtualizacao(Date ageDtAtualizacao) {
        this.ageDtAtualizacao = ageDtAtualizacao;
    }
    
    public Sala getSalaId() {
        return salaId;
    }

    public void setSalaId(Sala salaId) {
        this.salaId = salaId;
    }
    
    public Pessoa getPesIdResponsavel() {
        return pesIdResponsavel;
    }

    public void setPesIdResponsavel(Pessoa pesIdResponsavel) {
        this.pesIdResponsavel = pesIdResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.agendamentoId, other.agendamentoId)) {
            return false;
        }
        return true;
    }
}