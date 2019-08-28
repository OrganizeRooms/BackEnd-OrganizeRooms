package br.com.organizerooms.dto;

import java.util.Date;

/**
 *
 * @author Lucas Jansen
 */
public class IngredienteDTO {

    private Long id;
    private String nome;
    private Date dataCadastro;
    private Long usuarioId;

    public IngredienteDTO() {
    }

    public IngredienteDTO(Long id, String nome, Date dataCadastro, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.usuarioId = usuarioId;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
