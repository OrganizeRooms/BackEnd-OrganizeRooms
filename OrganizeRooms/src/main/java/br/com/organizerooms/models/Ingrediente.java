package br.com.organizerooms.models;

import br.com.organizerooms.dto.IngredienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ingrediente")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingrediente_id;

    @Column(unique = true)
    private String nome;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataCadatro;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingrediente")
    private List<Receita> receitas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Ingrediente() {
    }

    public Ingrediente(String nome, Usuario usuario) {
        this.nome = nome.toUpperCase();
        this.usuario = usuario;
    }

    public Ingrediente(String nome) {
        this(null, nome, null);
    }

    public Ingrediente(Long id, String nome, Date dataCadatro) {
        this.ingrediente_id = id;
        this.nome = nome.toUpperCase();
        this.dataCadatro = dataCadatro;
    }

    public Ingrediente(IngredienteDTO obj) {
        this.ingrediente_id = obj.getId();
        this.nome = obj.getNome().toUpperCase();
        this.dataCadatro = obj.getDataCadastro();
        this.usuario = new Usuario(obj.getUsuarioId());
    }

    public Long getId() {
        return ingrediente_id;
    }

    public void setId(Long id) {
        this.ingrediente_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadatro() {
        return dataCadatro;
    }

    public void setDataCadatro(Date dataCadatro) {
        this.dataCadatro = dataCadatro;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    ;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ingrediente_id);
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
        final Ingrediente other = (Ingrediente) obj;
        return Objects.equals(this.ingrediente_id, other.ingrediente_id);
    }

}
