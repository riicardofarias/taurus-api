package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class BaseModel {
    public BaseModel(long id) {
        setId(id);
    }

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    public boolean isNew(){
        return id == null;
    }
}
