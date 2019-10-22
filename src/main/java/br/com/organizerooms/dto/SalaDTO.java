package br.com.organizerooms.dto;

import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Unidade;
import br.com.organizerooms.models.Sala;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Eder Jean Dias
 */
public class SalaDTO {

    private Long salaId;
    private String salaNome;
    private Integer salaLotacao;
    private Boolean salaAtiva;
    private Date salaDtCadastro;
    private Date salaDtAtualizacao;
    private Pessoa pesIdCadastro;
    private Pessoa pesIdAtualizacao;
    private Unidade salaUnidade;

    public SalaDTO() {
    }

    public SalaDTO(Long salaId, String salaNome, Integer salaLotacao, Boolean salaAtiva,
            Date salaDtCadastro, Date salaDtAtualizacao, Pessoa pesIdCadastro, Pessoa pesIdAtualizacao, Unidade salaUnidade) {
        this.salaId = salaId;
        this.salaNome = salaNome;
        this.salaLotacao = salaLotacao;
        this.salaAtiva = salaAtiva;
        this.salaDtCadastro = salaDtCadastro;
        this.salaDtAtualizacao = salaDtAtualizacao;
        this.pesIdCadastro = pesIdCadastro;
        this.pesIdAtualizacao = pesIdAtualizacao;
        this.salaUnidade = salaUnidade;
    }

    public SalaDTO(Sala obj) {
        this.salaId = obj.getSalaId();
        this.salaNome = obj.getSalaNome();
        this.salaLotacao = obj.getSalaLotacao();
        this.salaAtiva = obj.getSalaAtiva();
        this.salaDtCadastro = obj.getSalaDtCadastro();
        this.salaDtAtualizacao = obj.getSalaDtAtualizacao();
        this.pesIdCadastro = obj.getPesIdCadastro();
        this.pesIdAtualizacao = obj.getPesIdAtualizacao();
        this.salaUnidade = obj.getSalaUnidade();
    }

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }

    public String getSalaNome() {
        return salaNome;
    }

    public void setSalaNome(String salaNome) {
        this.salaNome = salaNome;
    }

    public Integer getSalaLotacao() {
        return salaLotacao;
    }

    public void setSalaLotacao(Integer salaLotacao) {
        this.salaLotacao = salaLotacao;
    }

    public Boolean getSalaAtiva() {
        return salaAtiva;
    }

    public void setSalaAtiva(Boolean salaAtiva) {
        this.salaAtiva = salaAtiva;
    }

    public Date getSalaDtCadastro() {
        return salaDtCadastro;
    }

    public void setSalaDtCadastro(Date salaDtCadastro) {
        this.salaDtCadastro = salaDtCadastro;
    }

    public Date getSalaDtAtualizacao() {
        return salaDtAtualizacao;
    }

    public void setSalaDtAtualizacao(Date salaDtAtualizacao) {
        this.salaDtAtualizacao = salaDtAtualizacao;
    }

    public Pessoa getPesIdCadastro() {
        return pesIdCadastro;
    }

    public void setPesIdCadastro(Pessoa pesIdCadastro) {
        this.pesIdCadastro = pesIdCadastro;
    }

    public Pessoa getPesIdAtualizacao() {
        return pesIdAtualizacao;
    }

    public void setPesIdAtualizacao(Pessoa pesIdAtualizacao) {
        this.pesIdAtualizacao = pesIdAtualizacao;
    }

    public Unidade getSalaUnidade() {
        return salaUnidade;
    }

    public void setSalaUnidade(Unidade salaUnidade) {
        this.salaUnidade = salaUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.salaId);
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
        final SalaDTO other = (SalaDTO) obj;
        if (!Objects.equals(this.salaId, other.salaId)) {
            return false;
        }
        return true;
    }
}
