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
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private Long ageId;

    @Column
    private String ageAssunto;

    @Column
    private String ageDescricao;

    /*
    EM ANDAMENTO
    CANCELADO
    CONCLUIDO
    AGENDADO
    */
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
    @JoinColumn(name = "ageSala")
    private Sala ageSala;

    @ManyToOne
    @JoinColumn(name = "agePesResponsavel")
    private Pessoa agePesResponsavel;

    @Column
    private Long agePesCadastro;

    @Column
    private Long agePesAtualizacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "reserva_equipamento",
            joinColumns = @JoinColumn(name = "equId"),
            inverseJoinColumns = @JoinColumn(name = "ageId"))
    private List<Equipamento> equipamentos;
    
    @OneToMany(mappedBy = "parAgendamento")
    private List<Participante> participantes;



    public Agendamento() {
    }

    public Agendamento(Long ageId, String ageAssunto, String ageDescricao, String ageStatus, Date ageData, Date ageHoraInicio,
            Date ageHoraFim, Date ageDtCadastro, Date ageDtAtualizacao, Sala ageSala, Pessoa agePesResponsavel, Long agePesCadastro, Long agePesAtualizacao,
            List<Equipamento> equipamentos, List<Participante> participantes) {
        this.ageId = ageId;
        this.ageAssunto = ageAssunto;
        this.ageDescricao = ageDescricao;
        this.ageStatus = ageStatus;
        this.ageData = ageData;
        this.ageHoraInicio = ageHoraInicio;
        this.ageHoraFim = ageHoraFim;
        this.ageDtCadastro = ageDtCadastro;
        this.ageDtAtualizacao = ageDtAtualizacao;
        this.ageSala = ageSala;
        this.agePesResponsavel = agePesResponsavel;
        this.agePesCadastro = agePesCadastro;
        this.agePesAtualizacao = agePesAtualizacao;
        this.equipamentos = equipamentos;
        this.participantes = participantes;
    }

    public Agendamento(AgendamentoDTO obj) {
        this.ageId = obj.getAgeId();
        this.ageAssunto = obj.getAgeAssunto();
        this.ageDescricao = obj.getAgeDescricao();
        this.ageStatus = obj.getAgeStatus();
        this.ageData = obj.getAgeData();
        this.ageHoraInicio = obj.getAgeHoraInicio();
        this.ageHoraFim = obj.getAgeHoraFim();
        this.ageDtCadastro = obj.getAgeDtCadastro();
        this.ageDtAtualizacao = obj.getAgeDtAtualizacao();
        this.ageSala = obj.getAgeSala();
        this.agePesResponsavel = obj.getAgePesResponsavel();
        this.agePesCadastro = obj.getAgePesCadastro();
        this.agePesAtualizacao = obj.getAgePesAtualizacao();
        this.equipamentos = obj.getEquipamentos();
        this.participantes = obj.getParticipantes();
    }

    public Long getAgeId() {
        return ageId;
    }

    public void setAgeId(Long ageId) {
        this.ageId = ageId;
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

    public Sala getAgeSala() {
        return ageSala;
    }

    public void setAgeSala(Sala ageSala) {
        this.ageSala = ageSala;
    }

    public Pessoa getAgePesResponsavel() {
        return agePesResponsavel;
    }

    public void setAgePesResponsavel(Pessoa agePesResponsavel) {
        this.agePesResponsavel = agePesResponsavel;
    }
    
        public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.ageId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.ageId, other.ageId)) {
            return false;
        }
        return true;
    }

}
