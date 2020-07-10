package br.com.gransistemas.taurus.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Table
@Entity(name = "devices_events")
@DynamicUpdate
public class DeviceEvent extends BaseModel {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    public Device getDevice() { return device; }
    public void setDevice(Device device) { this.device = device; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
