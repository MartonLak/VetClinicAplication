package org.fasttrackit.trainginspring.Service;

import org.fasttrackit.trainginspring.Repo.ConsultationRepo;
import org.fasttrackit.trainginspring.messaging.Tut1Sender;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.model.ConsultationOriginal;
import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Consultation;
import org.fasttrackit.trainginspring.model.OwnersOriginal;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultationService
{
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;
    @Value("${server.port}") // SpEL (Spring Expression Language)
    private String serverPort;
    private final ConsultationRepo repository;

    public ConsultationService(ConsultationRepo repository) {
        this.repository = repository;
    }

    public ConsultationOriginal createNewConsultation(ConsultationOriginal request)
    {

                        /*SaveInRepo*/
        Consultation newConsultation = new Consultation();
        newConsultation.setAnimalConsulted(request.getAnimalConsulted());
        newConsultation.setConsultationId(request.getConsultationId());
        newConsultation.setOwnersAnimalConsulted(request.getOwnersAnimalConsulted());
        newConsultation.setVet(request.getVet());
        Consultation saveEntity = this.repository.save(newConsultation);

        /*Notification*/
        String message = "Consultation with ID:"+ saveEntity.getConsultationId().toString() + " and VetID:"+saveEntity.getVet().getId().toString() + "(Name:"+saveEntity.getVet().getFirstName() +") Created at";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Created '" + message + "'");
        return mapEntityToConsultRepo(saveEntity);
    }
    public String findConsultationById(Long consultationID)
    {
        Optional<Consultation> foundEntity = repository.findById(consultationID);
        if(!foundEntity.isPresent())
        {
            return null;
        }
        return "ConsultationID= "+foundEntity.map(entityToMap->mapEntityToConsultRepo(entityToMap)).get().getConsultationId().toString() +"\r\n"+ foundEntity.map(entityToMap->mapEntityToConsultRepo(entityToMap)).get().getAnimalConsulted().toString()+foundEntity.map(entityToMap->mapEntityToConsultRepo(entityToMap)).get().getVet().toString()+"\r\n"+foundEntity.map(entityToMap->mapEntityToConsultRepo(entityToMap)).get().getOwnersAnimalConsulted().toString();
    }
    public ConsultationOriginal updateConsultation (ConsultationOriginal request)
    {
        Consultation newConsult1 = new Consultation();
        newConsult1.setAnimalConsulted(request.getAnimalConsulted());
        newConsult1.setConsultationId(request.getConsultationId());
        newConsult1.setOwnersAnimalConsulted(request.getOwnersAnimalConsulted());
        newConsult1.setVet(request.getVet());
        newConsult1.setConsultationId(request.getConsultationId());
        Consultation saveEntity = this.repository.save(newConsult1);
        return mapEntityToConsultRepo(saveEntity);
    }
    public List<ConsultationOriginal> findAllConsultations()
    {
        List<Consultation> foundEntity = repository.findAll();

        //return this.repository.findAll().stream().map(entity->mapEntityToConsultRepo(entity)).collect(Collectors.toList());
        return foundEntity.stream().map(entity->mapEntityToConsultRepo(entity)).collect(Collectors.toList());
    }
    public void deleteConsultation(Long id)
    {
        /*Notification*/
        String message = "Consultation with ID"+ id.toString()+ "Deleted at";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Created '" + message + "'");
        this.repository.deleteById(id);
    }
    public ConsultationOriginal mapEntityToConsultRepo(Consultation entity)
    {

        ConsultationOriginal response = new ConsultationOriginal();
        response.setAnimalConsulted(entity.getAnimalConsulted());
        response.setConsultationId(entity.getConsultationId());
        response.setOwnersAnimalConsulted(entity.getOwnersAnimalConsulted());
        response.setVet(entity.getVet());
        return response;
    }
}
