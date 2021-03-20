package org.fasttrackit.trainginspring.Service;

import org.fasttrackit.trainginspring.Repo.ConsultationRepo;
import org.fasttrackit.trainginspring.messaging.Tut1Sender;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.model.ConsultationOriginal;
import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Consultation;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
