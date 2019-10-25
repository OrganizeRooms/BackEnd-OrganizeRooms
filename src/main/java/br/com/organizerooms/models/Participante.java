package br.com.organizerooms.models;


import br.com.organizerooms.dto.ParticipanteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Eder Jean Dias
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "participacao")
public class Participante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parId;

    @Column
    private Integer parTipo;   
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pesId")
    private Pessoa pesId;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ageId")
    private Agendamento ageId;

    public Participante() {
    }

    public Participante(Long parId, Integer parTipo, Pessoa pesId, Agendamento ageId) {
        this.parId = parId;
        this.parTipo = parTipo;
        this.pesId = pesId;
        this.ageId = ageId;
    }
    
    public Participante(ParticipanteDTO obj) {
        this.parId = obj.getParId();
        this.parTipo = obj.getParTipo();
        this.pesId = obj.getPesId();
        this.ageId = obj.getAgeId();
    }

    public Long getParId() {
        return parId;
    }

    public void setParId(Long parId) {
        this.parId = parId;
    }

    public Integer getParTipo() {
        return parTipo;
    }

    public void setParTipo(Integer parTipo) {
        this.parTipo = parTipo;
    }

    public Pessoa getPesId() {
        return pesId;
    }

    public void setPesId(Pessoa pesId) {
        this.pesId = pesId;
    }

    public Agendamento getAgeId() {
        return ageId;
    }

    public void setAgeId(Agendamento ageId) {
        this.ageId = ageId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.parId);
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
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.parId, other.parId)) {
            return false;
        }
        return true;
    }
}
