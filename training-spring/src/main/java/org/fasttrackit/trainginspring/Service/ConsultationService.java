package org.fasttrackit.trainginspring.Service;

import org.fasttrackit.trainginspring.Repo.ConsultationRepo;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.model.ConsultationOriginal;
import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Consultation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService
{
    @Value("${server.port}") // SpEL (Spring Expression Language)
    private String serverPort;
    private final ConsultationRepo repository;

    public ConsultationService(ConsultationRepo repository) {
        this.repository = repository;
    }

    public ConsultationOriginal createNewAnimal(ConsultationOriginal request)
    {
        Consultation newConsultation = new Consultation();
        newConsultation.setAnimalConsulted(request.getAnimalConsulted());
        newConsultation.setConsultationId(request.getConsultationId());
        newConsultation.setOwnersAnimalConsulted(request.getOwnersAnimalConsulted());
        newConsultation.setVet(request.getVet());
        Consultation saveEntity = this.repository.save(newConsultation);
        return mapEntityToConsultRepo(saveEntity);
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
