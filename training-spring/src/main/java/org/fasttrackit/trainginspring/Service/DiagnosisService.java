package org.fasttrackit.trainginspring.Service;


import org.fasttrackit.trainginspring.Repo.DiagnosticsRepo;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.model.DiagnosticsOriginal;
import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Diagnosis;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    public DiagnosisService(DiagnosticsRepo repository) {
        this.repository = repository;
    }

    public DiagnosticsOriginal createNewDiagnosis(DiagnosticsOriginal request)
    {
                        /*Notification*/
        String message = "Diagnosis Created at";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Created '" + message + "'");
                 /*SaveInRepo*/

        Diagnosis newDiagnosis = new Diagnosis();
        newDiagnosis.setConsultationIdReferenced(request.getConsultationIdReferenced());
        newDiagnosis.setDescription(request.getDescription());
        newDiagnosis.setDiagnosticsId(request.getDiagnosticsId());
        newDiagnosis.setRecommendations(request.getRecommendations());
        newDiagnosis.setTitle(request.getTitle());
        Diagnosis saveEntity = this.repository.save(newDiagnosis);
                return mapEntityToAnimalsRepo(saveEntity);
    }
    public void deleteDiagnosis(Long id)
    {
        /*Notification*/
        String message = "Diagnosis Deleted at";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Created '" + message + "'");
        this.repository.deleteById(id);
    }
    public DiagnosticsOriginal mapEntityToAnimalsRepo(Diagnosis entity)
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
