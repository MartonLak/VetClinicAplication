package org.fasttrackit.trainginspring.Controller;
import java.util.List;

import org.fasttrackit.trainginspring.Service.ConsultationService;
import org.fasttrackit.trainginspring.Service.OwnersService;
import org.fasttrackit.trainginspring.Service.VetService;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.Service.AnimalService;
import org.fasttrackit.trainginspring.model.ConsultationOriginal;
import org.fasttrackit.trainginspring.model.OwnersOriginal;
import org.fasttrackit.trainginspring.Repo.AnimalRepo;
import org.fasttrackit.trainginspring.model.VetsOriginal;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final AnimalRepo repository;
    private final AnimalService servicee;
    private final OwnersService serviceOwner;
    private final VetService serviceVet;
    private final ConsultationService consultService;
    String[] a;



    HelloController(AnimalRepo repository, AnimalService servicee, OwnersService serviceOwner, VetService serviceVet, ConsultationService consultService) {
        this.repository = repository;
        this.servicee = servicee;
        this.serviceOwner = serviceOwner;
        this.serviceVet = serviceVet;
        this.consultService = consultService;
    }

    @GetMapping("/api/salut")
    public String getHelloMessage() {
        return "asd" + "\n";
    }


    /*Animal Endpoints:*/

    @GetMapping("/animals")
    List<AnimalsOriginal> all() {
        return servicee.findAllAnimals();
    }

    @PostMapping("/animals")
    public AnimalsOriginal createNewAnimal(@RequestBody AnimalsOriginal newAnimals) {
        return servicee.createNewAnimal(newAnimals);
    }

    @GetMapping("/animals/{id}")
    public AnimalsOriginal FindAnimal(@PathVariable Long id) {
        return servicee.findAnimal(id);
    }

    @PutMapping("animals/{id}")
    AnimalsOriginal replaceAnimals(@RequestBody AnimalsOriginal newAnimals, @PathVariable Long id) {
        return servicee.updateAnimals(newAnimals);
    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimals(@PathVariable Long id) {
        this.servicee.deleteAnimal(id);
    }


    /*Owner Endpoints:*/


    @GetMapping("/owner/{id}")
    public OwnersOriginal findOwner(@PathVariable Long id) {
        return serviceOwner.findOwnerById(id);
    }

    @GetMapping("/owner")
    List<OwnersOriginal> findAllOwners() {
        return serviceOwner.findAllOwners();
    }

    @PostMapping("/owner")
    public OwnersOriginal createNewOwner(@RequestBody OwnersOriginal newOwner) {
        return serviceOwner.createNewOwner(newOwner);
    }

    @PutMapping("/owner/{id}")
    public OwnersOriginal updateOwner(@RequestBody OwnersOriginal newOwner) {
        return serviceOwner.updateOwner(newOwner);
    }

    @DeleteMapping("/owner/{id}")
    void deleteOwners(@PathVariable Long id) {
        this.serviceOwner.deleteOwner(id);
    }

    /*Vet Endpoints:*/


    @GetMapping("/vet/{id}")
    public VetsOriginal findVet(@PathVariable Long id) {
        return serviceVet.findVetById(id);
    }

    @GetMapping("/vet")
    List<VetsOriginal> findAllVets() {
        return serviceVet.findAllVets();
    }

    @PostMapping("/vet")
    public VetsOriginal createNewVet(@RequestBody VetsOriginal newVet) {
        return serviceVet.createNewVet(newVet);
    }

    @PutMapping("/vet/{id}")
    public VetsOriginal Update(@RequestBody VetsOriginal newVet) {
        return serviceVet.updateVets(newVet);
    }

    @DeleteMapping("/vet/{id}")
    void deleteVet(@PathVariable Long id) {
        this.serviceVet.deleteVet(id);
    }

                                                      /*Consultation Endpoints:*/

    @PostMapping("/Consultation")
    public ConsultationOriginal createNewConsultation(@RequestBody ConsultationOriginal newConsult)
    {
        return consultService.createNewAnimal(newConsult);
    }
    @DeleteMapping("/Consultation/{id}")
    void deleteConsultation(@PathVariable Long id)
    {
        this.consultService.deleteConsultation(id);
    }

}
