package org.fasttrackit.trainginspring.Service;

import com.sun.xml.bind.v2.model.core.ID;
import org.fasttrackit.trainginspring.Additional.AnymalException;
import org.fasttrackit.trainginspring.Entity.Animals;
import org.fasttrackit.trainginspring.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AnimalService
{

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

    public AnimalsOriginal mapEntityToAnimalsRepo(Animals entity)
    {
        AnimalsOriginal response = new AnimalsOriginal();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSpice(entity.getSpice());
        return response;
    }

}
