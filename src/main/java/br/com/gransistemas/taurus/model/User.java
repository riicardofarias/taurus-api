package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "users")
@DynamicUpdate
public class User extends BaseModel {
    public User() { }

    public User(long id){
        setId(id);
    }

    @JsonProperty(value = "name")
    @Column(name = "name")
    private String name;

    @JsonProperty(value = "email")
    @Column(name = "email")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", updatable = false)
    private User parent;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public User getParent() { return parent; }
    public void setParent(User parent) { this.parent = parent; }
}
