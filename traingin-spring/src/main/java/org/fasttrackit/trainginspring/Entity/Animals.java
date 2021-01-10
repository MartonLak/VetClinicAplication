package org.fasttrackit.trainginspring.Entity;
import org.fasttrackit.trainginspring.Additional.Species;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Animals
{
    private @Id @GeneratedValue Long id;
    private String name;
    private @Enumerated @Column Species spice;


    public Animals() {

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Species getSpice() {
        return this.spice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpice(Species spice) {
        this.spice = spice;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Animals))
            return false;
        Animals animals = (Animals) o;
        return Objects.equals(this.id, animals.id) && Objects.equals(this.name, animals.name)
                && Objects.equals(this.spice, animals.spice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.spice);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.spice + '\'' + '}'+"\r\n";
    }
}