package org.fasttrackit.trainginspring.model.DTO;

import org.springframework.web.bind.annotation.RequestBody;


public class OwnerDTO
{
    long id;
    String firstName;
    String lastName;
    String animalsID;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAnimalsID() {
        return animalsID;
    }

    public void setAnimalsID(String animalsID) {
        this.animalsID = animalsID;
    }
}
