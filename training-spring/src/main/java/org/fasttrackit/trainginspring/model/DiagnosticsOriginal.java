package org.fasttrackit.trainginspring.model;

import org.fasttrackit.trainginspring.model.Entity.Consultation;

import javax.persistence.Column;

public class DiagnosticsOriginal

{
    private Long diagnosticsId;
    private  Long consultationIdReferenced;
    private  String Title;
    private String Description;
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
}
