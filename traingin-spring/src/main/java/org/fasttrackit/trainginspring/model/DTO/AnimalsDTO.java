package org.fasttrackit.trainginspring.model.DTO;

import org.fasttrackit.trainginspring.Additional.Species;

public class AnimalsDTO
{
    String ID;
    Species spice;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Species getSpice() {
        return spice;
    }

    public void setSpice(Species spice) {
        this.spice = spice;
    }
}
