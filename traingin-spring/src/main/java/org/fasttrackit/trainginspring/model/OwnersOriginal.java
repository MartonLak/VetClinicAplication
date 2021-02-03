package org.fasttrackit.trainginspring.model;

import org.fasttrackit.trainginspring.model.Entity.Animals;

import java.util.List;

public class OwnersOriginal
{
    private Long id;
    private String lastName;
    private String firstName;
    Integer  CNP;
    private Long animalsID;
    private List<Animals> anmials;

    public Long getAnimalsID() {
        return animalsID;
    }

    public void setAnimalsID(Long animalsID) {
        this.animalsID = animalsID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getCNP() {
        return CNP;
    }

    public void setCNP(Integer CNP) {
        this.CNP = CNP;
    }

    public List<Animals> getAnmials() {
        return anmials;
    }

    public void setAnmials(List<Animals> anmials) {
        this.anmials = anmials;
    }
}

