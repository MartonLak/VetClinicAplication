package org.fasttrackit.trainginspring.model.Entity;

import org.fasttrackit.trainginspring.model.DTO.AnimalsDTO;
import org.hibernate.service.spi.InjectService;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity(name = "consultation")
public class Consultation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;

    @OneToOne
    @JoinColumn(unique = true)
    private Animals animalConsulted;

    @OneToOne
    @JoinColumn(unique = true)
    private Owners ownersAnimalConsulted;

    @ManyToOne
    private Vet vet;



    @ManyToMany(mappedBy = "animalsEntity")
    private List<Owners> OwnersEntity;

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
        return OwnersEntity;
    }

    public void setOwnersEntity(List<Owners> ownersEntity) {
        OwnersEntity = ownersEntity;
    }
}
