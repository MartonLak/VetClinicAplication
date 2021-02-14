package org.fasttrackit.trainginspring.Repo;

import org.fasttrackit.trainginspring.model.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long>
{

}
