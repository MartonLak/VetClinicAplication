package org.fasttrackit.trainginspring.Service;


import org.fasttrackit.trainginspring.Repo.DiagnosticsRepo;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.model.DiagnosticsOriginal;
import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Diagnosis;
import org.fasttrackit.trainginspring.model.Entity.Owners;
import org.fasttrackit.trainginspring.model.OwnersOriginal;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiagnosisService
{
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;
    @Value("${server.port}") // SpEL (Spring Expression Language)
    private String serverPort;
    private final DiagnosticsRepo repository;

    Diagnosis newText = new Diagnosis();
    public DiagnosisService(DiagnosticsRepo repository) {
        this.repository = repository;
    }

    public DiagnosticsOriginal createNewDiagnosis(DiagnosticsOriginal request)
    {
                 /*SaveInRepo*/
        Diagnosis newDiagnosis = new Diagnosis();
        newDiagnosis.setConsultationIdReferenced(request.getConsultationIdReferenced());
        newDiagnosis.setDescription(request.getDescription());
        newDiagnosis.setRecommendations(request.getRecommendations());
        newDiagnosis.setTitle(request.getTitle());
        Diagnosis saveEntity = this.repository.save(newDiagnosis);
        /*Notification*/
        String message = "Diagnosis Created at" + saveEntity.toString();
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Created '" + message + "'");
        return mapEntityToDiagRepo(saveEntity);
    }
    public DiagnosticsOriginal updateDiagnosis(DiagnosticsOriginal request)
    {
        Diagnosis newDiag = new Diagnosis();
        newDiag.setConsultationIdReferenced(request.getConsultationIdReferenced());
        newDiag.setDescription(request.getDescription());
        newDiag.setDiagnosticsId(request.getDiagnosticsId());
        newDiag.setRecommendations(request.getRecommendations());
        newDiag.setTitle(request.getTitle());
        Diagnosis saveEntity = this.repository.save(newDiag);
        return mapEntityToDiagRepo(saveEntity);
    }
    public DiagnosticsOriginal findOwnerById(Long diagID)
    {
        Optional<Diagnosis> foundEntity = repository.findById(diagID);

        if(!foundEntity.isPresent())
        {
            return null;
        }
        return foundEntity.map(entityToMap->mapEntityToDiagRepo(entityToMap)).get();
    }
    public List<DiagnosticsOriginal> findAllDiag()
    {
        return this.repository.findAll().stream().map(entity->mapEntityToDiagRepo(entity)).collect(Collectors.toList());
    }

    public void deleteDiagnosis(Long id)
    {
        /*Notification*/
        String message = "Diagnosis Deleted at";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Created '" + message + "'");
        this.repository.deleteById(id);
    }
    public DiagnosticsOriginal mapEntityToDiagRepo(Diagnosis entity)
    {
        DiagnosticsOriginal response = new DiagnosticsOriginal();
        response.setConsultationIdReferenced(entity.getConsultationIdReferenced());
        response.setDescription(entity.getDescription());
        response.setDiagnosticsId(entity.getDiagnosticsId());
        response.setRecommendations(entity.getRecommendations());
        response.setTitle(entity.getTitle());
        return response;
    }
}
