package br.com.organizerooms.models;

import br.com.organizerooms.utils.SenhaUtils;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pesId;

    @Column
    private String pesLogin;

    @Column(updatable = false)
    private String pesSenha;

    @Column
    private String pesNome;

    @Column
    private String pesEmail;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date pesDtNascimento;

    @Column
    private String pesSexo;

    @Column
    private String pesSetor;

    @Column
    private String pesFuncao;

    @Column
    private Integer pesDdd;

    @Column
    private String pesTelefone;

    @Column
    private String pesTipoInclusao;

    @Column
    private String pesCriacao;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date pesDtCadastro;

    @Column
    private String pesAtualizacao;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date pesDtAtualizacao;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "perfil")
//    private PerfilEnum perfil;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<EmailEnviado> emailEnviados;

    public Pessoa() {
    }

    public Pessoa(Long pesId, String pesLogin, String pesSenha, String pesNome, String pesEmail, Date pesDtNascimento, String pesSexo, String pesSetor, String pesFuncao, Integer pesDdd, String pesTelefone, String pesTipoInclusao, String pesCriacao, Date pesDtCadastro, String pesAtualizacao, Date pesDtAtualizacao, List<EmailEnviado> emailEnviados) {
        this.pesId = pesId;
        this.pesLogin = pesLogin;
        this.pesSenha = SenhaUtils.gerarBCrypt(pesSenha);
        this.pesNome = pesNome;
        this.pesEmail = pesEmail;
        this.pesDtNascimento = pesDtNascimento;
        this.pesSexo = pesSexo;
        this.pesSetor = pesSetor;
        this.pesFuncao = pesFuncao;
        this.pesDdd = pesDdd;
        this.pesTelefone = pesTelefone;
        this.pesTipoInclusao = pesTipoInclusao;
        this.pesCriacao = pesCriacao;
        this.pesDtCadastro = pesDtCadastro;
        this.pesAtualizacao = pesAtualizacao;
        this.pesDtAtualizacao = pesDtAtualizacao;
        this.emailEnviados = emailEnviados;
    }

}
