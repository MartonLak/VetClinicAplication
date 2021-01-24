package org.fasttrackit.trainginspring.Controller;
import java.util.List;

import org.fasttrackit.trainginspring.Service.OwnersService;
import org.fasttrackit.trainginspring.model.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.Service.AnimalService;
import org.fasttrackit.trainginspring.model.Entity.OwnersOriginal;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController
{
    private final AnimalRepo repository;
    private final AnimalService servicee;
    private final OwnersService serviceOwner;
    String[] a;

    HelloController(AnimalRepo repository, AnimalService servicee, OwnersService serviceOwner)
    {
        this.repository = repository;
        this.servicee = servicee;
        this.serviceOwner = serviceOwner;
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
    @PostMapping("/AddOwnerService")
    public OwnersOriginal createNewOwner(@RequestBody OwnersOriginal newOwner)
    {
        return serviceOwner.createNewOwner(newOwner);
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
    @DeleteMapping("/DeleteOwner/{id}")
    void deleteOwners(@PathVariable Long id)
    {
        this.serviceOwner.deleteOwner(id);
    }
}
