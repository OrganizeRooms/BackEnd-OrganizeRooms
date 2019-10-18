/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.models;


import br.com.organizerooms.dto.NotificacaoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Felipe
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "notificacao")
public class Notificacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notId;

    @Column
    private String notDescricao;
    
    @Column
    private boolean notAtiva;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date notDtCadastro;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date notDtAtualizacao;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "notPesAtualizacao")
    @LastModifiedBy
    private Pessoa notPesAtualizacao;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pesId")
    private Pessoa pessoaId;

    public Notificacao(Long notId, String notDescricao, boolean notAtiva, Date notDtCadastro, Date notDtAtualizacao, Pessoa notPesAtualizacao, Pessoa pessoaId) {
        this.notId = notId;
        this.notDescricao = notDescricao;
        this.notAtiva = notAtiva;
        this.notDtCadastro = notDtCadastro;
        this.notDtAtualizacao = Calendar.getInstance().getTime();
        this.notPesAtualizacao = notPesAtualizacao;
        this.pessoaId = pessoaId;
    }
    
    public Notificacao(NotificacaoDTO notificacao) {
        this.notId = notificacao.getNotId();
        this.notDescricao = notificacao.getNotDescricao();
        this.notAtiva = notificacao.isNotAtiva();
        this.notDtCadastro = notificacao.getNotDtCadastro();
        this.notDtAtualizacao = Calendar.getInstance().getTime();
        this.notPesAtualizacao = notificacao.getNotPesAtualizacao();
        this.pessoaId = notificacao.getPessoaId();
    }

    public Long getNotId() {
        return notId;
    }

    public void setNotId(Long notId) {
        this.notId = notId;
    }

    public String getNotDescricao() {
        return notDescricao;
    }

    public void setNotDescricao(String notDescricao) {
        this.notDescricao = notDescricao;
    }

    public boolean isNotAtiva() {
        return notAtiva;
    }

    public void setNotAtiva(boolean notAtiva) {
        this.notAtiva = notAtiva;
    }

    public Date getNotDtCadastro() {
        return notDtCadastro;
    }

    public void setNotDtCadastro(Date notDtCadastro) {
        this.notDtCadastro = notDtCadastro;
    }

    public Date getNotDtAtualizacao() {
        return notDtAtualizacao;
    }

    public void setNotDtAtualizacao(Date notDtAtualizacao) {
        this.notDtAtualizacao = notDtAtualizacao;
    }

    public Pessoa getNotPesAtualizacao() {
        return notPesAtualizacao;
    }

    public void setNotPesAtualizacao(Pessoa notPesAtualizacao) {
        this.notPesAtualizacao = notPesAtualizacao;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.notId);
        hash = 83 * hash + Objects.hashCode(this.notDescricao);
        hash = 83 * hash + (this.notAtiva ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.notDtCadastro);
        hash = 83 * hash + Objects.hashCode(this.notDtAtualizacao);
        hash = 83 * hash + Objects.hashCode(this.notPesAtualizacao);
        hash = 83 * hash + Objects.hashCode(this.pessoaId);
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
        final Notificacao other = (Notificacao) obj;
        if (this.notAtiva != other.notAtiva) {
            return false;
        }
        if (!Objects.equals(this.notDescricao, other.notDescricao)) {
            return false;
        }
        if (!Objects.equals(this.notId, other.notId)) {
            return false;
        }
        if (!Objects.equals(this.notDtCadastro, other.notDtCadastro)) {
            return false;
        }
        if (!Objects.equals(this.notDtAtualizacao, other.notDtAtualizacao)) {
            return false;
        }
        if (!Objects.equals(this.notPesAtualizacao, other.notPesAtualizacao)) {
            return false;
        }
        if (!Objects.equals(this.pessoaId, other.pessoaId)) {
            return false;
        }
        return true;
    }
    
    
    
}
