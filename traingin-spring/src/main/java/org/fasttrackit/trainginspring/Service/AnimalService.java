package org.fasttrackit.trainginspring.Service;

import com.sun.xml.bind.v2.model.core.ID;
import org.fasttrackit.trainginspring.Additional.AnymalException;
import org.fasttrackit.trainginspring.Entity.Animals;
import org.fasttrackit.trainginspring.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
import org.springframework.stereotype.Service;


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

        AnimalsOriginal respondObject = new AnimalsOriginal();
        respondObject.setId(saveEntity.getId());
        respondObject.setName(saveEntity.getName());
        respondObject.setSpice(saveEntity.getSpice());
        return respondObject;
    }



}
