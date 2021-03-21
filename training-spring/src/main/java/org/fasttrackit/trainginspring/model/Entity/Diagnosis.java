package org.fasttrackit.trainginspring.model.Entity;

import javax.persistence.*;

@Entity(name = "diagnosis")
public class Diagnosis
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diagnosticsId;


    @Column
    private  Long consultationIdReferenced;

    @Column
    private  String title;

    @Column
    private String description;

    @Column
    private String recommendations;

    @Transient
    @OneToOne(mappedBy = "consultationId")
    private Consultation consult;

    public Long getDiagnosticsId() {
        return diagnosticsId;
    }

    public void setDiagnosticsId(Long diagnosticsId) {
        this.diagnosticsId = diagnosticsId;
    }

    public Long getConsultationIdReferenced() {
        return consultationIdReferenced;
    }

    public void setConsultationIdReferenced(Long consultationIdReferenced) {
        this.consultationIdReferenced = consultationIdReferenced;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosticsId=" + diagnosticsId +
                ", consultationIdReferenced=" + consultationIdReferenced +
                ", Title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", Recommendations='" + recommendations + '\'' +
                '}';
    }
}
