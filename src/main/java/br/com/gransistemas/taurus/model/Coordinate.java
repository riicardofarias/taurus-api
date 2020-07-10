package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Coordinate {
    @Getter @Setter
    @JsonProperty(value = "index")
    private int index;

    @Getter @Setter
    @JsonProperty(value = "lat")
    private double latitude;

    @Getter @Setter
    @JsonProperty(value = "lng")
    private double longitude;
}
