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
    Animals newEmployee(@RequestBody Animals newAnimals)
    {
        return repository.save(newAnimals);
    }
    @GetMapping("/FindAnimal/{id}")
    Animals one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new AnymalException(id));
    }
    @DeleteMapping("/DeleteAnimals/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
