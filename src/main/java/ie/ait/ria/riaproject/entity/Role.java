package ie.ait.ria.riaproject.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "role")
@ApiModel(value = "Role class", description = "Assigned role for every user")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    public Role() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
