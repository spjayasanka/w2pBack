package com.w2p.model.entity;

import javax.persistence.*;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String Description;

    @Column(name = "orgUserName")
    private String orgUserName;

    public Organization() {
    }

    public String getOrgUserName() {
        return orgUserName;
    }

    public void setOrgUserName(String orgUserName) {
        this.orgUserName = orgUserName;
    }

    public Organization(String name, String description) {
        this.name = name;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
