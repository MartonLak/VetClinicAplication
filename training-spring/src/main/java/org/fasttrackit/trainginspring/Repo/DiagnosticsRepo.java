package org.fasttrackit.trainginspring.Repo;

import org.apache.tomcat.util.Diagnostics;
import org.fasttrackit.trainginspring.model.Entity.Consultation;
import org.fasttrackit.trainginspring.model.Entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticsRepo  extends JpaRepository<Diagnosis, Long>
{

}
