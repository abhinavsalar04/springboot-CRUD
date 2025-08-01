package com.springbootbootcamp.project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @Column(name = "asset_id")
    @GeneratedValue
    private int id;

    @Column(name = "asset_type")
    private String type;

    @Column(name = "asset_name")
    private String name;

    @OneToOne(mappedBy = "asset")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
