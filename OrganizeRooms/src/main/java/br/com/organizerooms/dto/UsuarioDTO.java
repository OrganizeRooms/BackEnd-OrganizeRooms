package br.com.organizerooms.dto;

import br.com.organizerooms.enums.PerfilEnum;
import br.com.organizerooms.models.Usuario;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Leandro Prado
 */
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private PerfilEnum perfil;

    private String senha;

    private String dsPerfil;

    private String telefoneCelular;

    private String telefoneFixo;

    private String rg;

    private String cpf;

    private String rua;

    private int numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private String usuarioCriacao;

    private String usuarioAtualizacao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String email, PerfilEnum perfil, String senha, String dsPerfil, String telefoneCelular, String telefoneFixo, String rg, String cpf, String rua, int numero, String complemento, String bairro, String cidade, String estado, String cep, Date dataCriacao, Date dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.senha = senha;
        this.dsPerfil = dsPerfil;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;

    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.perfil = obj.getPerfil();
        this.senha = obj.getSenha();
        this.dsPerfil = this.getDsPerfil();
        this.telefoneCelular = obj.getTelefoneCelular();
        this.telefoneFixo = obj.getTelefoneFixo();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.rua = obj.getRua();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.bairro = obj.getBairro();
        this.cidade = obj.getCidade();
        this.estado = obj.getEstado();
        this.cep = obj.getCep();
        this.dataAtualizacao = obj.getDataAtualizacao();
        this.dataCriacao = obj.getDataCriacao();
        this.usuarioCriacao = obj.getUsuarioCriacao();
        this.usuarioAtualizacao = obj.getUsuarioAtualizacao();
    }

    public String getDsPerfil() {
        if (this.perfil.equals(PerfilEnum.ROLE_ADMIN)) {
            return "Administrador";
        }
        if (this.perfil.equals(PerfilEnum.ROLE_CLIENTE)) {
            return "Cliente";
        }
        if (this.perfil.equals(PerfilEnum.ROLE_TECNICO)) {
            return "Tecnico";
        }
        if (this.perfil.equals(PerfilEnum.ROLE_USUARIO)) {
            return "Usuario";
        }
        return "";
    }

    public void setDsPerfil(String dsPerfil) {
        this.dsPerfil = dsPerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public String getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(String usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", perfil=" + perfil + ", senha=" + senha + ", dsPerfil=" + dsPerfil + ", telefoneCelular=" + telefoneCelular + ", telefoneFixo=" + telefoneFixo + ", rg=" + rg + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", usuarioCriacao=" + usuarioCriacao + ", usuarioAtualizacao=" + usuarioAtualizacao + '}';
    }

}
