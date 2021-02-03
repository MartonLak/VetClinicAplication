package org.fasttrackit.trainginspring.Repo;

import org.fasttrackit.trainginspring.model.Entity.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnersRepo extends JpaRepository<Owners, Long>
{
}
