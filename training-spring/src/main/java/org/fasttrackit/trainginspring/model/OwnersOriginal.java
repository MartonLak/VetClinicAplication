package org.fasttrackit.trainginspring.model;

import org.fasttrackit.trainginspring.model.Entity.Animals;

import javax.persistence.Column;
import java.util.List;

public class OwnersOriginal
{
    private Long id;
    private String lastName;
    private String firstName;
    private Integer  CNP;
    private String phoneNumber;
    private String email;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}

