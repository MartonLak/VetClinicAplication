package org.fasttrackit.trainginspring.Service;


import org.fasttrackit.trainginspring.model.Entity.Owners;
import org.fasttrackit.trainginspring.model.OwnersOriginal;
import org.fasttrackit.trainginspring.Repo.OwnersRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        newOwner1.setCnp(request.getCNP());
        newOwner1.setEmail(request.getEmail());
        newOwner1.setPhoneNumber(request.getPhoneNumber());
        Owners saveEntity  =this.repository.save(newOwner1);
        return mapEntityTOwnersRepo(saveEntity);
    }
    public OwnersOriginal findOwnerById(Long ownerID)
    {
        Optional<Owners> foundEntity = repository.findById(ownerID);

        if(!foundEntity.isPresent())
        {
            return null;
        }
        return foundEntity.map(entityToMap->mapEntityTOwnersRepo(entityToMap)).get();
    }
    public List<OwnersOriginal> findAllOwners()
    {
        return this.repository.findAll().stream().map(entity->mapEntityTOwnersRepo(entity)).collect(Collectors.toList());
    }
    public OwnersOriginal updateOwner(OwnersOriginal request)
    {
        Owners newOwner1 = new Owners();
        newOwner1.setFirstName(request.getFirstName());
        newOwner1.setLastName(request.getLastName());
        newOwner1.setId(request.getId());
        newOwner1.setCnp(request.getCNP());
        newOwner1.setEmail(request.getEmail());
        newOwner1.setPhoneNumber(request.getPhoneNumber());
        Owners saveEntity  =this.repository.save(newOwner1);
        return mapEntityTOwnersRepo(saveEntity);
    }
    public OwnersOriginal mapEntityTOwnersRepo(Owners entity)
    {
        OwnersOriginal response = new OwnersOriginal();
        response.setId(entity.getId());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setCNP(entity.getCnp());
        response.setEmail(entity.getEmail());
        response.setPhoneNumber(entity.getPhoneNumber());
        return response;
    }
    public void deleteOwner(Long Id)
    {
        this.repository.deleteById(Id);
    }

}
