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
    private  String Title;

    @Column
    private String Description;

    @Column
    private String Recommendations;

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
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRecommendations() {
        return Recommendations;
    }

    public void setRecommendations(String recommendations) {
        Recommendations = recommendations;
    }
    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosticsId=" + diagnosticsId +
                ", consultationIdReferenced=" + consultationIdReferenced +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Recommendations='" + Recommendations + '\'' +
                '}';
    }
}
