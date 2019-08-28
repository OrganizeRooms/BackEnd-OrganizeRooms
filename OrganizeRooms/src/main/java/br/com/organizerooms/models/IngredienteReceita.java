package br.com.organizerooms.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
 * @author Lucas Jansen
 */
//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@Table(name = "ingrediente_receita");
public class IngredienteReceita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    
    private Ingrediente ingrediente_id;

    
    private Receita receita_id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente_id;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente_id = ingrediente;
    }

    public Receita getReceita() {
        return receita_id;
    }

    public void setReceita(Receita receita) {
        this.receita_id = receita;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final IngredienteReceita other = (IngredienteReceita) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  

}
