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
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "zones")
@DynamicUpdate
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@JsonIgnoreProperties(value = {"users"})
public class Zone extends BaseModel {
    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "color")
    private String color;

    @Setter
    @Type(type = "jsonb")
    @Column(name = "area", columnDefinition = "jsonb")
    private List<Coordinate> points = new ArrayList<>();

    @Getter @Setter
    @JsonProperty(value = "created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Getter @Setter
    @JsonProperty(value = "active")
    @Column(name = "active")
    private boolean active;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_zones", joinColumns = @JoinColumn(name = "zone_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public void addUser(User user){
        this.users.add(user);
    }

    @JsonProperty(value = "points")
    public List<Coordinate> getPoints() {
        return points.stream()
            .sorted(Comparator.comparingInt(Coordinate::getIndex))
        .collect(Collectors.toList());
    }
}
