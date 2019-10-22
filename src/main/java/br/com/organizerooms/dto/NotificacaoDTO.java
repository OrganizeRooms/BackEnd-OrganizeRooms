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
    private Pessoa notPesAtualizacao;
    private Pessoa pessoaId;

    public NotificacaoDTO() {
    }

    public NotificacaoDTO(Long notId, String notDescricao, Boolean notAtiva, Date notDtCadastro, Date notDtAtualizacao, Pessoa notPesAtualizacao, Pessoa pessoaId) {
        this.notId = notId;
        this.notDescricao = notDescricao;
        this.notAtiva = notAtiva;
        this.notDtCadastro = notDtCadastro;
        this.notDtAtualizacao = notDtAtualizacao;
        this.notPesAtualizacao = notPesAtualizacao;
        this.pessoaId = pessoaId;
    }

    public NotificacaoDTO(Notificacao notificacao) {
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
