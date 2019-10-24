/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.organizerooms.dto;

import br.com.organizerooms.models.*;
import java.util.Calendar;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Felipe
 */
public class NotificacaoDTO {

    private Long notId;
    private String notDescricao;
    private Boolean notAtiva;
    private Date notDtCadastro;
    private Date notDtAtualizacao;
    private Long notPesAtualizacao;
    private Pessoa pessoaId;
    private Long notPesCadastro;  

    public NotificacaoDTO() {
    }

    public NotificacaoDTO(Long notId, String notDescricao, Boolean notAtiva, Date notDtCadastro, Date notDtAtualizacao, 
            Long notPesAtualizacao, Pessoa pessoaId, Long notPesCadastro) {
        this.notId = notId;
        this.notDescricao = notDescricao;
        this.notAtiva = notAtiva;
        this.notDtCadastro = notDtCadastro;
        this.notDtAtualizacao = notDtAtualizacao;
        this.notPesAtualizacao = notPesAtualizacao;
        this.pessoaId = pessoaId;
        this.notPesCadastro = notPesCadastro;
    }

    public NotificacaoDTO(Notificacao notificacao) {
        this.notId = notificacao.getNotId();
        this.notDescricao = notificacao.getNotDescricao();
        this.notAtiva = notificacao.isNotAtiva();
        this.notDtCadastro = notificacao.getNotDtCadastro();
        this.notDtAtualizacao = Calendar.getInstance().getTime();
        this.notPesAtualizacao = notificacao.getNotPesAtualizacao();
        this.pessoaId = notificacao.getPessoaId();
        this.notPesCadastro = notificacao.getNotPesCadastro();
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

    public Boolean isNotAtiva() {
        return notAtiva;
    }

    public void setNotAtiva(Boolean notAtiva) {
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

    public Long getNotPesAtualizacao() {
        return notPesAtualizacao;
    }

    public void setNotPesAtualizacao(Long notPesAtualizacao) {
        this.notPesAtualizacao = notPesAtualizacao;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }
    
    public Long getNotPesCadastro() {
        return notPesCadastro;
    }

    public void setNotPesCadastro(Long notPesCadastro) {
        this.notPesCadastro = notPesCadastro;
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotificacaoDTO other = (NotificacaoDTO) obj;
        if (!Objects.equals(this.notId, other.notId)) {
            return false;
        }
        if (!Objects.equals(this.notDescricao, other.notDescricao)) {
            return false;
        }
        if (!Objects.equals(this.notAtiva, other.notAtiva)) {
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
