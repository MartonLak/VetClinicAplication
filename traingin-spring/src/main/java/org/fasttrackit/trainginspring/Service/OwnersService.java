package org.fasttrackit.trainginspring.Service;


import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.model.Entity.Owners;
import org.fasttrackit.trainginspring.model.Entity.OwnersOriginal;
import org.fasttrackit.trainginspring.repo.OwnersRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OwnersService
{
    @Value("${server.port}") // SpEL (Spring Expression Language)
    private String serverPort;
    private final OwnersRepo repository;

    public OwnersService(OwnersRepo repository)
    {
        this.repository = repository;
    }
    public OwnersOriginal createNewOwner(OwnersOriginal request)
    {
        Owners newOwner1 = new Owners();
        newOwner1.setFirstName(request.getFirstName());
        newOwner1.setLastName(request.getLastName());
        newOwner1.setCNP(request.getCNP());
        newOwner1.setAnmials(request.getAnmials());
        newOwner1.setAnimalsID(request.getAnimalsID());
        Owners saveEntity  =this.repository.save(newOwner1);
        return mapEntityTOwnersRepo(saveEntity);
    }
    public OwnersOriginal mapEntityTOwnersRepo(Owners entity)
    {
        OwnersOriginal response = new OwnersOriginal();
        response.setId(entity.getId());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setCNP(entity.getCNP());
        response.setAnmials(entity.getAnmials());
        response.setAnimalsID(entity.getAnimalsID());
        return response;
    }
    public void deleteOwner(Long Id)
    {
        this.repository.deleteById(Id);
    }

}
