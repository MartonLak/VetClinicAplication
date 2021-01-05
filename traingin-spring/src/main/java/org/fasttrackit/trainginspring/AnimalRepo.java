package org.fasttrackit.trainginspring;

import org.fasttrackit.trainginspring.Entity.Animals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AnimalRepo extends JpaRepository<Animals, Long>
{
}
