package org.fasttrackit.trainginspring.Repo;

import org.fasttrackit.trainginspring.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AnimalRepo extends JpaRepository<Animals, Long>
{

}
