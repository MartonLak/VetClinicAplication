package org.fasttrackit.trainginspring.Controller;
import java.util.List;

import org.fasttrackit.trainginspring.Additional.AnymalException;
import org.fasttrackit.trainginspring.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.Service.AnimalService;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
import org.fasttrackit.trainginspring.Entity.Animals;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController
{
    private final AnimalRepo repository;
    private final AnimalService servicee;
    String[] a;

    HelloController(AnimalRepo repository, AnimalService servicee)
    {
        this.repository = repository;
        this.servicee = servicee;
    }
    @GetMapping("/api/salut")
    public String getHelloMessage()
    {
        return "asd"+"\n";
    }

    @GetMapping("/AllAnimals")
    List<AnimalsOriginal> all()
    {
        return servicee.findAllAnimals();
    }
    //old
    /*@PostMapping("/AddAnimals")

    Animals getNewAnimals(@RequestBody Animals newAnimals)
    {
        return repository.save(newAnimals);
    }*/
    //old
    @PostMapping("/AddAnimalsService")
    public AnimalsOriginal createNewAnimal(@RequestBody AnimalsOriginal newAnimals)
    {
        return  servicee.createNewAnimal(newAnimals);
    }
    @GetMapping("/FindAnimal/{id}")

    public AnimalsOriginal FindAnimal(@PathVariable Long id)
    {
        return servicee.FindAnimal(id);
    }
    @PutMapping("UpdateAnimals/{id}")
    AnimalsOriginal replaceAnimals(@RequestBody AnimalsOriginal newAnimals, @PathVariable Long id)
    {
        return servicee.updateAnimals(newAnimals);
    }
    @DeleteMapping("/DeleteAnimals/{id}")
    void deleteAnimals(@PathVariable Long id)
    {
       this.servicee.deleteAnimal(id);
    }
}
