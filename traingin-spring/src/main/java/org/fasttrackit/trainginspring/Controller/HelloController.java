package org.fasttrackit.trainginspring.Controller;

import java.util.List;

import org.fasttrackit.trainginspring.Additional.AnymalException;
import org.fasttrackit.trainginspring.AnimalRepo;
import org.fasttrackit.trainginspring.Entity.Animals;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController
{
    private final AnimalRepo repository;
    String[] a;

    HelloController(AnimalRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/api/salut")
    public String getHelloMessage()
    {
        return "asd"+"\n";
    }
    @GetMapping("/AllAnimals")
    List<Animals> all()
    {
        return repository.findAll();
    }

    @PostMapping("/AddAnimals")
    Animals getNewAnimals(@RequestBody Animals newAnimals)
    {
        return repository.save(newAnimals);
    }
    @GetMapping("/FindAnimal/{id}")
    Animals FindAnimal(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new AnymalException(id));
    }
    @PutMapping("UpdateAnimals/{id}")
    Animals replaceAnimals(@RequestBody Animals newAnimals, @PathVariable Long id)
    {
        return repository.findById(id).map(animals -> {
            animals.setName(newAnimals.getName());
            animals.setSpice(newAnimals.getSpice());
            return repository.save(animals);
        }).orElseGet(()->{
            newAnimals.setId(id);
            return repository.save(newAnimals);
        });


    }
    @DeleteMapping("/DeleteAnimals/{id}")
    void deleteAnimals(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
