package org.fasttrackit.trainginspring.model;


import javax.persistence.*;
import java.util.List;

@Entity(name="owners")
public class Owners
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column
    private Integer  CNP;
    @Column
    private Long animalsID;

    public Long getAnimalsID() {
        return animalsID;
    }

    public void setAnimalsID(Long animalsID) {
        this.animalsID = animalsID;
    }

    @ManyToMany
    private List<Animals> anmials;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ownersName) {
        this.lastName = ownersName;
    }

    public List<Animals> getAnmials() {
        return anmials;
    }

    public void setAnmials(List<Animals> anmials) {
        this.anmials = anmials;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP=" + CNP +
                ", anmials=" + anmials +
                '}';
    }
}
