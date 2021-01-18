package org.fasttrackit.trainginspring.Service;

import com.sun.xml.bind.v2.model.core.ID;
import org.fasttrackit.trainginspring.Additional.AnymalException;
import org.fasttrackit.trainginspring.Entity.Animals;
import org.fasttrackit.trainginspring.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
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

    public AnimalService(AnimalRepo repository) {
        this.repository = repository;
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
