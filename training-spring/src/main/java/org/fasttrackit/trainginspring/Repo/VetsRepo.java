package org.fasttrackit.trainginspring.Repo;

import org.fasttrackit.trainginspring.model.Entity.Vet;
import org.fasttrackit.trainginspring.model.VetsOriginal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VetsRepo extends JpaRepository<Vet, Long>
{

}
