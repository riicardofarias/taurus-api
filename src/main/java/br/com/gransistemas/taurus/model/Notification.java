package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notifications")
@DynamicUpdate
public class Notification extends BaseModel {
    @JsonIgnoreProperties(value = {"position"})
    @ManyToOne
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    private Device device;

    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private Event event;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty(value = "created_at")
    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    public Device getDevice() { return device; }
    public void setDevice(Device device) { this.device = device; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
