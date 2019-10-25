package br.com.organizerooms.dto;

import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Agendamento;
import br.com.organizerooms.models.Participante;

/**
 *
 * @author Eder Jean Dias
 */
public class ParticipanteDTO {
    private Long parId;
    private Integer parTipo;   
    private Pessoa pesId;
    private Agendamento ageId;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(Long parId, Integer parTipo, Pessoa pesId, Agendamento ageId) {
        this.parId = parId;
        this.parTipo = parTipo;
        this.pesId = pesId;
        this.ageId = ageId;
    }
    
    public ParticipanteDTO(Participante obj) {
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
}
