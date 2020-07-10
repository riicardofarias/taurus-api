package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
@DynamicUpdate
@JsonIgnoreProperties(value = { "users" })
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Device extends BaseModel {

    @Getter @Setter
    @JsonProperty(value = "name")
    @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter
    @JsonProperty(value = "imei")
    @Column(name = "imei", nullable = false)
    private String imei;

    @Getter @Setter
    @JsonProperty(value = "plate")
    @Column(name = "plate_number")
    private String plate;

    @Getter @Setter
    @JsonProperty(value = "phone")
    @Column(name = "phone_number")
    private String phone;

    @Getter @Setter
    @JsonProperty(value = "gps_name")
    @Column(name = "gps_name")
    private String gpsName;

    @Getter @Setter
    @JsonProperty(value = "status")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", updatable = false)
    private Status status = Status.offline;

    @Getter @Setter
    @JsonProperty(value = "created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt = new Date();

    @Getter @Setter
    @JsonProperty(value = "active")
    @Column(name = "active")
    private boolean active = true;

    @Getter @Setter
    @JsonProperty(value = "icon")
    @Column(name = "icon", nullable = false)
    private String icon = "ic-default.svg";

    @Getter @Setter
    @JsonProperty(value = "attrs")
    @Type(type = "jsonb")
    @Column(name = "attrs", columnDefinition = "jsonb")
    private Set<Attr> attrs = new HashSet<>();

    @Getter @Setter
    @JsonProperty(value = "position")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", updatable = false)
    private Position position;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_devices", joinColumns = @JoinColumn(name = "device_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public void addUser(User user){
        this.users.add(user);
    }
}
