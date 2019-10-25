package br.com.organizerooms.dto;

import java.util.Date;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Sala;
import br.com.organizerooms.models.Agendamento;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
/**
 *
 * @author Eder Jean Dias
 */
public class AgendamentoDTO {
    private Long agendamentoId;
    private String ageAssunto;
    private String ageDescricao;
    private String ageStatus;
    private Date ageData;
    private Date ageHoraInicio;
    private Date ageHoraFim;
    private Date ageDtCadastro;
    private Date ageDtAtualizacao;
    private Sala salaId;
    private Pessoa pesIdResponsavel;
    private Long agePesCadastro;
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

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long agendamentoId, String ageAssunto, String ageDescricao, String ageStatus, Date ageData, Time ageHoraInicio, Time ageHoraFim, Date ageDtCadastro, Date ageDtAtualizacao, Sala salaId, Pessoa pesIdResponsavel,
        Long agePesCadastro, Long agePesAtualizacao) {
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
    
    public AgendamentoDTO(Agendamento obj) {
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
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.agendamentoId);
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
        final AgendamentoDTO other = (AgendamentoDTO) obj;
        if (!Objects.equals(this.agendamentoId, other.agendamentoId)) {
            return false;
        }
        return true;
    }
}
