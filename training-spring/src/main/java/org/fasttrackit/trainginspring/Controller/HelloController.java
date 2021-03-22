package org.fasttrackit.trainginspring.Controller;
import java.util.List;

import org.fasttrackit.trainginspring.Service.*;
import org.fasttrackit.trainginspring.model.*;
import org.fasttrackit.trainginspring.Repo.AnimalRepo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final AnimalRepo repository;
    private final AnimalService animalService;
    private final OwnersService serviceOwner;
    private final VetService serviceVet;
    private final ConsultationService consultService;
    private final DiagnosisService diagnosisService;
    String[] a;



    HelloController(AnimalRepo repository, AnimalService animalService, OwnersService serviceOwner, VetService serviceVet, ConsultationService consultService, DiagnosisService diagnosisService) {
        this.repository = repository;
        this.animalService = animalService;
        this.serviceOwner = serviceOwner;
        this.serviceVet = serviceVet;
        this.consultService = consultService;
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/api/salut")
    public String getHelloMessage() {
        return "asd" + "\n";
    }


    /*Animal Endpoints:*/

    @GetMapping("/animals")
    List<AnimalsOriginal> all() {
        return animalService.findAllAnimals();
    }

    @PostMapping("/animals")
    public AnimalsOriginal createNewAnimal(@RequestBody AnimalsOriginal newAnimals) {
        return animalService.createNewAnimal(newAnimals);
    }

    @GetMapping("/animals/{id}")
    public AnimalsOriginal findAnimal(@PathVariable Long id) {
        return animalService.findAnimal(id);
    }

    @PutMapping("animals/{id}")
    AnimalsOriginal replaceAnimals(@RequestBody AnimalsOriginal newAnimals, @PathVariable Long id) {
        return animalService.updateAnimals(newAnimals);
    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimals(@PathVariable Long id) {
        this.animalService.deleteAnimal(id);
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
    public VetsOriginal update(@RequestBody VetsOriginal newVet) {
        return serviceVet.updateVets(newVet);
    }

    @DeleteMapping("/vet/{id}")
    void deleteVet(@PathVariable Long id) {
        this.serviceVet.deleteVet(id);
    }

                                                      /*Consultation Endpoints:*/

    @GetMapping("/consultation")

    public List<ConsultationOriginal> findAllConsul()
    {
        return consultService.findAllConsultations();
    }
    @GetMapping("/consultation/{id}")
    public String findConsult(@PathVariable Long id)
    {
        return consultService.findConsultationById(id);
    }
    @PutMapping("/consultation/{id}")
    public  ConsultationOriginal updateConsult(@RequestBody ConsultationOriginal newConsult)
    {
        return consultService.updateConsultation(newConsult);
    }
    @PostMapping("/consultation")
    public ConsultationOriginal createNewConsultation(@RequestBody ConsultationOriginal newConsult)
    {
        return consultService.createNewConsultation(newConsult);
    }
    @DeleteMapping("/consultation/{id}")
    void deleteConsultation(@PathVariable Long id)
    {
        this.consultService.deleteConsultation(id);
    }

                                     /*Diagnosis Endpoints:*/

    @PostMapping("/diagnosis")
    public DiagnosticsOriginal createNewDiagnosis(@RequestBody DiagnosticsOriginal newDiag)
    {

        return diagnosisService.createNewDiagnosis(newDiag);
    }
    @GetMapping("/diagnosis/{id}")
    public DiagnosticsOriginal findDiagById(@PathVariable Long id)
    {
        return diagnosisService.findOwnerById(id);
    }
    @PutMapping("diagnosis/{id}")
    public DiagnosticsOriginal updateDiag(@RequestBody DiagnosticsOriginal diag)
    {
        return diagnosisService.updateDiagnosis(diag);
    }
    @GetMapping("/diagnosis")
    public List<DiagnosticsOriginal>  findDiag()
    {
        return diagnosisService.findAllDiag();
    }
    @DeleteMapping("/diagnosis/{id}")
    void deleteDiagnosis(@PathVariable Long id)
    {
        this.diagnosisService.deleteDiagnosis(id);
    }
}
