package com.springbootbootcamp.project.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "_id")
    @GeneratedValue
    private int _id;

    @Column(name = "name")
    private String name;

    @Column(name = "profession")
    private String profession;

    @OneToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    public User(){}
    public User(int _id, String name, String profession){
        this._id = _id;
        this.name = name;
        this.profession = profession;
    }

    public int get_id(){
        return this._id;
    }

    public String getName(){
        return this.name;
    }

    public String getProfession(){
        return this.profession;
    }

    public Asset getAsset(){
        return this.asset;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setProfession(String profession){
        this.profession = profession;
    }

    public void setAsset(Asset asset){
        this.asset = asset;
    }
}
