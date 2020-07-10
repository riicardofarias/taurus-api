package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attr {
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "value")
    private String value;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
