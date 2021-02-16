package org.fasttrackit.trainginspring.model.Entity;
import org.fasttrackit.trainginspring.Additional.Species;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "animals")
public class Animals
{
    private @Id @GeneratedValue Long id;
    private String name;
    private @Enumerated(EnumType.STRING)
    @Column Species Species;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "animalConsulted")
    private List<Consultation> consultationEntity;

    public List<Consultation> getConsultationEntity() {
        return consultationEntity;
    }

    public void setConsultationEntity(List<Consultation> consultationEntity) {
        this.consultationEntity = consultationEntity;
    }

    public Animals() {

    }
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Species getSpecies() {
        return this.Species;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(Species species) {
        this.Species = species;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Animals))
            return false;
        Animals animals = (Animals) o;
        return Objects.equals(this.id, animals.id) && Objects.equals(this.name, animals.name)
                && Objects.equals(this.Species, animals.Species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.Species);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.Species + '\'' + '}'+"\r\n";
    }
}