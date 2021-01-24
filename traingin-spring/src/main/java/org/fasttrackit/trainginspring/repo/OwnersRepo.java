package org.fasttrackit.trainginspring.repo;

import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.Entity.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnersRepo extends JpaRepository<Owners, Long>
{
}
