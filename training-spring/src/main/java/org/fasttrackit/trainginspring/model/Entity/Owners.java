package org.fasttrackit.trainginspring.model.Entity;


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

    public List<Animals> getAnimalsEntity() {
        return animalsEntity;
    }

    public void setAnimalsEntity(List<Animals> animalsEntity) {
        this.animalsEntity = animalsEntity;
    }

    public List<Consultation> getConsultationEntity() {
        return consultationEntity;
    }

    public void setConsultationEntity(List<Consultation> consultationEntity) {
        this.consultationEntity = consultationEntity;
    }

    @Column
    private String phoneNumber;
    @Column
    private String email;
    @ManyToMany
    private List<Animals>  animalsEntity;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, mappedBy = "ownersAnimalConsulted")
    private List<Consultation> consultationEntity;

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

}
