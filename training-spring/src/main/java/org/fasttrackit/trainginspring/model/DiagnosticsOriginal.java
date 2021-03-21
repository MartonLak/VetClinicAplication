package org.fasttrackit.trainginspring.model;

public class DiagnosticsOriginal

{
    private Long diagnosticsId;
    private  Long consultationIdReferenced;
    private  String title;
    private String description;
    private String recommendations;

    @Override
    public String toString() {
        return "DiagnosticsOriginal{" +
                "diagnosticsId=" + diagnosticsId +
                ", consultationIdReferenced=" + consultationIdReferenced +
                ", Title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", Recommendations='" + recommendations + '\'' +
                '}';
    }

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
}
