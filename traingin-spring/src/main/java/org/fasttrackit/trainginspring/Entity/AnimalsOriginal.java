package org.fasttrackit.trainginspring.Entity;

import org.fasttrackit.trainginspring.Additional.Species;

public class AnimalsOriginal
{
    private Long id;
    private String name;
    private Species spice;

    public AnimalsOriginal(Long id, String name, Species spice) {
        this.id = id;
        this.name = name;
        this.spice = spice;
    }

    public AnimalsOriginal() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpice() {
        return spice;
    }

    public void setSpice(Species spice) {
        this.spice = spice;
    }



    @Override
    public String toString() {
        return "AnimalsOriginal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spice=" + spice +
                '}';
    }

}
