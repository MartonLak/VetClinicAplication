package org.fasttrackit.trainginspring.model.Entity;


import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
@Entity(name="vets")
public class Vet
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

    public List<Consultation> getAlConsultations() {
        return alConsultations;
    }

    public void setAlConsultations(List<Consultation> alConsultations) {
        this.alConsultations = alConsultations;
    }

    @Column
    private Date yearOfGraduation;
    @Column
    private String specialization;
    @Column
    private String phoneNumber ;
    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private  List<Consultation> alConsultations;

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

    public Date getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(Date yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

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

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP=" + CNP +
                ", yearOfGraduation=" + yearOfGraduation +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
