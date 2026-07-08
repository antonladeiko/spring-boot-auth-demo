package com.mustgen.spring_boot_auth_demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import java.util.Set;

@Getter
@Entity
@Table(
    name = "roles",
    uniqueConstraints = {@UniqueConstraint(columnNames = "name")}
)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role(String name, String description) {
        if (!name.startsWith("ROLE_")) {
            throw new IllegalArgumentException("Role should start with prefix: ROLE_");
        }

        this.name = name;
        this.description = name;
    }

    protected Role() {
    }

}
