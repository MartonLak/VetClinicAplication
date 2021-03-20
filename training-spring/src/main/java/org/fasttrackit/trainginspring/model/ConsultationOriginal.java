package org.fasttrackit.trainginspring.model;


import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Owners;
import org.fasttrackit.trainginspring.model.Entity.Vet;

public class ConsultationOriginal
{
    private Long consultationId;
    private Animals animalConsulted;
    private Owners ownersAnimalConsulted;
    private Vet vet;

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }

    public Animals getAnimalConsulted() {
        return animalConsulted;
    }

    public void setAnimalConsulted(Animals animalConsulted) {
        this.animalConsulted = animalConsulted;
    }

    public Owners getOwnersAnimalConsulted() {
        return ownersAnimalConsulted;
    }

    public void setOwnersAnimalConsulted(Owners ownersAnimalConsulted) {
        this.ownersAnimalConsulted = ownersAnimalConsulted;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    @Override
    public String toString() {
        return "ConsultationOriginal{" +
                "consultationId=" + consultationId +
                ", animalConsulted=" + animalConsulted +
                ", ownersAnimalConsulted=" + ownersAnimalConsulted +
                ", vet=" + vet +
                '}';
    }
}
