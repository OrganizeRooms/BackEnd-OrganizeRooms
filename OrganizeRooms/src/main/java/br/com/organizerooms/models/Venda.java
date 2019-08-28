package br.com.organizerooms.models;

import br.com.organizerooms.dto.VendaDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Eder Jean Dias
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataVenda;
    
    @Column
    private Double valorTotal;
    
    @Column
    private String descricao;
    
    @Column
    private String nomeVendedor;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Venda() {
    }
    
    public Venda(VendaDTO obj) {
        this.id = obj.getId();
        this.dataVenda = obj.getDataVenda();
        this.valorTotal = obj.getValorTotal();
        this.descricao = obj.getDescricao();
        this.nomeVendedor = obj.getNomeVendedor();
        this.usuario = obj.getUsuario();
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + ", descricao=" + descricao + ", nomeVendedor=" + nomeVendedor + ", usuario=" + usuario + '}';
    }
}
