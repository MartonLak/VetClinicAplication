package org.fasttrackit.trainginspring.Service;


import org.fasttrackit.trainginspring.Repo.AnimalRepo;
import org.fasttrackit.trainginspring.Repo.VetsRepo;
import org.fasttrackit.trainginspring.model.Entity.Vet;
import org.fasttrackit.trainginspring.model.OwnersOriginal;
import org.fasttrackit.trainginspring.model.VetsOriginal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetService
{
    @Value("${server.port}") // SpEL (Spring Expression Language)
    private String serverPort;
    private final VetsRepo repository;

    public VetService(VetsRepo repository) {
        this.repository = repository;
    }
    public VetsOriginal createNewVet(VetsOriginal request)
    {
        Vet newVet1 = new Vet();
        newVet1.setCNP(request.getCNP());
        newVet1.setEmail(request.getEmail());
        newVet1.setFirstName(request.getFirstName());
        newVet1.setLastName(request.getLastName());
        newVet1.setPhoneNumber(request.getPhoneNumber());
        newVet1.setSpecialization(request.getSpecialization());
        newVet1.setYearOfGraduation(request.getYearOfGraduation());
        Vet saveEntity = this.repository.save(newVet1);
        return mapEntityToAnimalsRepo(saveEntity);
    }
    public VetsOriginal updateVets(VetsOriginal request)
    {
        Vet newVet1 = new Vet();
        newVet1.setId(request.getId());
        newVet1.setCNP(request.getCNP());
        newVet1.setEmail(request.getEmail());
        newVet1.setFirstName(request.getFirstName());
        newVet1.setLastName(request.getLastName());
        newVet1.setPhoneNumber(request.getPhoneNumber());
        newVet1.setSpecialization(request.getSpecialization());
        newVet1.setYearOfGraduation(request.getYearOfGraduation());
        Vet saveEntity = this.repository.save(newVet1);
        return mapEntityToAnimalsRepo(saveEntity);
    }
    public VetsOriginal findVetById(Long VetId)
    {
        Optional<Vet> foundEntity = repository.findById(VetId);
        if(!foundEntity.isPresent())
        {
            return null;
        }
        return foundEntity.map(entityToMap->mapEntityToAnimalsRepo(entityToMap)).get();
    }
    public List<VetsOriginal> findAllVets()
    {
        return this.repository.findAll().stream().map(entity->mapEntityToAnimalsRepo(entity)).collect(Collectors.toList());
    }
    public void deleteVet(Long id)
    {
        this.repository.deleteById(id);
    }
    public VetsOriginal mapEntityToAnimalsRepo(Vet entity)
    {
        VetsOriginal response = new VetsOriginal();
        response.setId(entity.getId());
        response.setCNP(entity.getCNP());
        response.setEmail(entity.getEmail());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setPhoneNumber(entity.getPhoneNumber());
        response.setSpecialization(entity.getSpecialization());
        response.setYearOfGraduation(entity.getYearOfGraduation());
        return response;
    }
}
