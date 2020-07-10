package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table
@Entity(name = "events")
@DynamicUpdate
@JsonIgnoreProperties(value = {"user"})
public class Event extends BaseModel {
    @NotNull @NotEmpty
    @JsonProperty(value = "name")
    @Column(name = "name")
    private String name;

    @Min(value = 0)
    @JsonProperty(value = "speed_limit")
    @Column(name = "speed_limit")
    private double speedLimit;

    @NotNull
    @JsonProperty(value = "type")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "event_type")
    public EventType type;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty(value = "created_at")
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSpeedLimit() { return speedLimit; }
    public void setSpeedLimit(double speedLimit) { this.speedLimit = speedLimit; }

    public EventType getType() { return type; }
    public void setType(EventType type) { this.type = type; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
