package org.fasttrackit.trainginspring.model.Entity;

import javax.persistence.*;

@Entity(name = "diagnosis")
public class Diagnosis
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diagnosticsId;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="consultationId", referencedColumnName = "id")
    private Long consultationId;*/

}
