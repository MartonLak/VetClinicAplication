package org.fasttrackit.trainginspring.model.Entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "consultation")
public class Consultation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Animals animalConsulted;

    @ManyToOne(cascade = CascadeType.ALL)
    private Owners ownersAnimalConsulted;

    @ManyToOne(cascade = CascadeType.ALL)
    private Vet vet;

    @Transient
    @OneToOne(mappedBy = "consult")
    private Diagnosis diag;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "animalsEntity")
    private List<Owners> ownersEntity;

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

    public List<Owners> getOwnersEntity() {
        return ownersEntity;
    }

    public void setOwnersEntity(List<Owners> ownersEntity) {
        this.ownersEntity = ownersEntity;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationId=" + consultationId +
                ", animalConsulted=" + animalConsulted +
                ", ownersAnimalConsulted=" + ownersAnimalConsulted +
                ", vet=" + vet +
                ", OwnersEntity=" + ownersEntity +
                '}';
    }
}
