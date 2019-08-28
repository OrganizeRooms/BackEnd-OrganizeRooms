package br.com.organizerooms.models;

import br.com.organizerooms.dto.VendaItemDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Eder Jean Dias
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "venda_item")
public class VendaItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Integer quantidade;

    @Column
    private Double valor;
    
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;
    
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_receita")
    private Receita receita;

    public VendaItem() {
    }

    public VendaItem(VendaItemDTO venda) {
        this.id = venda.getId();
        this.quantidade = venda.getQuantidade();
        this.valor = venda.getValor();
        this.venda = venda.getVenda();
        this.receita = venda.getReceita();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final VendaItem other = (VendaItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VendaItem{" + "id=" + id + ", quantidade=" + quantidade + ", valor=" + valor + ", venda=" + venda + ", usuario=" + usuario + ", receita=" + receita + '}';
    } 
}
