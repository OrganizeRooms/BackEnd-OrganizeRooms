package br.com.organizerooms.models;

import br.com.organizerooms.dto.PessoaDTO;
import br.com.organizerooms.enums.PerfilEnum;
import br.com.organizerooms.utils.SenhaUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pesId;

    @Column
    private String pesNome;

    @Column
    private String pesEmail;

    @Column(updatable = false)
    private String pesSenha;

    @Enumerated(EnumType.STRING)
    @Column(name = "pesPermissao")
    private PerfilEnum pesPermissao;
    
    @ManyToOne
    @JoinColumn(name = "uniId")
    private Unidade unidade;

    @JsonIgnore
    @OneToMany(mappedBy = "uniPesCadastro")
    private List<Unidade> unidadeCadastro;

    @JsonIgnore
    @OneToMany(mappedBy = "uniPesAtualizacao")
    private List<Unidade> unidadeAtualizacao;

    @Column
    private Integer pesDdd;

    @Column
    private String pesTelefone;

    // SIS = Cadastro manual
    // IMP = Por Importação
    @Column
    private String pesTipoInclusao;

    @ManyToOne
    @JoinColumn(name = "pesCadastro")
    @LastModifiedBy
    private Pessoa pesCadastro;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date pesDtCadastro;

    @ManyToOne
    @JoinColumn(name = "pesAtualizacao")
    @LastModifiedBy
    private Pessoa pesAtualizacao;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date pesDtAtualizacao;

    public Pessoa() {
    }

    public Pessoa(Long pesId, String pesNome, String pesEmail, String pesSenha, PerfilEnum pesPermissao, Unidade unidade,
            Integer pesDdd, String pesTelefone, String pesTipoInclusao, Pessoa pesCadastro, Date pesDtCadastro, Pessoa pesAtualizacao, Date pesDtAtualizacao) {
        this.pesId = pesId;
        this.pesNome = pesNome;
        this.pesEmail = pesEmail;
        this.pesSenha = SenhaUtils.gerarBCrypt(pesSenha);
        this.pesPermissao = pesPermissao;
        this.unidade = unidade;
        this.pesDdd = pesDdd;
        this.pesTelefone = pesTelefone;
        this.pesTipoInclusao = pesTipoInclusao;
        this.pesCadastro = pesCadastro;
        this.pesDtCadastro = pesDtCadastro;
        this.pesAtualizacao = pesAtualizacao;
        this.pesDtAtualizacao = pesDtAtualizacao;
    }

    public Pessoa(PessoaDTO obj) {
        this.pesId = obj.getPesId();
        this.pesNome = obj.getPesNome();
        this.pesEmail = obj.getPesEmail();
        this.pesSenha = obj.getPesSenha();
        this.pesPermissao = obj.getPesPermissao();
        this.pesDdd = obj.getPesDdd();
        this.pesTelefone = obj.getPesTelefone();
        this.pesTipoInclusao = obj.getPesTipoInclusao();
        this.pesCadastro = obj.getPesCadastro();
        this.pesDtCadastro = obj.getPesDtCadastro();
        this.pesAtualizacao = obj.getPesAtualizacao();
        this.pesDtAtualizacao = obj.getPesDtAtualizacao();
    }

    private String obterSenhaCrypt(PessoaDTO obj) {

        if (obj.getPesId() == null) {
            return SenhaUtils.gerarBCrypt(obj.getPesSenha());
        } else {
            return obj.getPesSenha();
        }
    }

    public Long getPesId() {
        return pesId;
    }

    public void setPesId(Long pesId) {
        this.pesId = pesId;
    }

    public String getPesSenha() {
        return pesSenha;
    }

    public void setPesSenha(String pesSenha) {
        this.pesSenha = pesSenha;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public PerfilEnum getPesPermissao() {
        return pesPermissao;
    }

    public void setPesPermissao(PerfilEnum pesPermissao) {
        this.pesPermissao = pesPermissao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    } 

    public List<Unidade> getUnidadeAtualizacao() {
        return unidadeAtualizacao;
    }

    public void setUnidadeAtualizacao(List<Unidade> unidadeAtualizacao) {
        this.unidadeAtualizacao = unidadeAtualizacao;
    }

    public Integer getPesDdd() {
        return pesDdd;
    }

    public void setPesDdd(Integer pesDdd) {
        this.pesDdd = pesDdd;
    }

    public String getPesTelefone() {
        return pesTelefone;
    }

    public void setPesTelefone(String pesTelefone) {
        this.pesTelefone = pesTelefone;
    }

    public String getPesTipoInclusao() {
        return pesTipoInclusao;
    }

    public void setPesTipoInclusao(String pesTipoInclusao) {
        this.pesTipoInclusao = pesTipoInclusao;
    }

    public List<Unidade> getUnidadeCadastro() {
        return unidadeCadastro;
    }

    public void setUnidadeCadastro(List<Unidade> unidadeCadastro) {
        this.unidadeCadastro = unidadeCadastro;
    }

    public Pessoa getPesCadastro() {
        return pesCadastro;
    }

    public void setPesCadastro(Pessoa pesCadastro) {
        this.pesCadastro = pesCadastro;
    }

    public Date getPesDtCadastro() {
        return pesDtCadastro;
    }

    public void setPesDtCadastro(Date pesDtCadastro) {
        this.pesDtCadastro = pesDtCadastro;
    }

    public Pessoa getPesAtualizacao() {
        return pesAtualizacao;
    }

    public void setPesAtualizacao(Pessoa pesAtualizacao) {
        this.pesAtualizacao = pesAtualizacao;
    }

    public Date getPesDtAtualizacao() {
        return pesDtAtualizacao;
    }

    public void setPesDtAtualizacao(Date pesDtAtualizacao) {
        this.pesDtAtualizacao = pesDtAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.pesId);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.pesId, other.pesId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "pesId=" + pesId + ", pesNome=" + pesNome + ", pesEmail=" + pesEmail + ", pesSenha=" + pesSenha + ", pesPermissao=" + pesPermissao + ", unidade=" + unidade + ", unidadeCadastro=" + unidadeCadastro + ", unidadeAtualizacao=" + unidadeAtualizacao + ", pesDdd=" + pesDdd + ", pesTelefone=" + pesTelefone + ", pesTipoInclusao=" + pesTipoInclusao + ", pesCadastro=" + pesCadastro + ", pesDtCadastro=" + pesDtCadastro + ", pesAtualizacao=" + pesAtualizacao + ", pesDtAtualizacao=" + pesDtAtualizacao + '}';
    }

}
