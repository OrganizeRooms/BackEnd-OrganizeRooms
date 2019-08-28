package br.com.organizerooms.dto;

import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.models.Venda;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Eder Jean Dias
 */
public class VendaDTO {

    private Long id;

    private String descricao;

    private Date dataVenda;

    private String nomeVendedor;

    private Double valorTotal;
    
    private Usuario usuario;

    public VendaDTO() {
    }

    public VendaDTO(Long id, String descricao, Date dataVenda, String nomeVendedor, Double valorTotal, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeVendedor = nomeVendedor;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
    }
    
    public VendaDTO(Venda obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
        this.dataVenda = obj.getDataVenda();
        this.nomeVendedor = obj.getNomeVendedor();
        this.valorTotal = obj.getValorTotal();
        this.usuario = obj.getUsuario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   

    @Override
    public String toString() {
        return "VendaDTO{" + "id=" + id + ", descricao=" + descricao + ", dataVenda=" + dataVenda + ", nomeVendedor=" + nomeVendedor + ", valorTotal=" + valorTotal + ", usuario=" + usuario + '}';
    }
}
