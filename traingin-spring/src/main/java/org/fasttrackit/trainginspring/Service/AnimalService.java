package org.fasttrackit.trainginspring.Service;

import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
import org.fasttrackit.trainginspring.repo.OwnersRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AnimalService
{
    @Value("${server.port}") // SpEL (Spring Expression Language)
    private String serverPort;
    private final AnimalRepo repository;
    private final OwnersRepo repositoryOwners;

    public AnimalService(AnimalRepo repository, OwnersRepo repositoryOwners) {
        this.repository = repository;
        this.repositoryOwners = repositoryOwners;
    }

    public AnimalsOriginal createNewAnimal(AnimalsOriginal request)
    {
        Animals newAnimal1 = new Animals();
        newAnimal1.setSpice(request.getSpice());
        newAnimal1.setName(request.getName());
        Animals saveEntity = this.repository.save(newAnimal1);
        return mapEntityToAnimalsRepo(saveEntity);

    }
    public AnimalsOriginal FindAnimal(Long animalID)
    {
        Optional<Animals> foundEntity = repository.findById(animalID);
        if(!foundEntity.isPresent())
        {
            return null;
        }
        return foundEntity.map(entityToMap -> mapEntityToAnimalsRepo(entityToMap)).get();
    }
    public List<AnimalsOriginal> findAllAnimals()
    {
        return this.repository.findAll().stream().map(entity->mapEntityToAnimalsRepo(entity)).collect(Collectors.toList());
    }
    public AnimalsOriginal updateAnimals(AnimalsOriginal request)
    {
        Animals newAnimal1 = new Animals();
        newAnimal1.setSpice(request.getSpice());
        newAnimal1.setId(request.getId());
        newAnimal1.setName(request.getName());
        Animals saveEntity = this.repository.save(newAnimal1);
        return mapEntityToAnimalsRepo(saveEntity);

    }
    public void deleteAnimal(Long ID)
    {
        this.repository.deleteById(ID);
    }

    public AnimalsOriginal mapEntityToAnimalsRepo(Animals entity)
    {
        AnimalsOriginal response = new AnimalsOriginal();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSpice(entity.getSpice());
        return response;
    }

}
