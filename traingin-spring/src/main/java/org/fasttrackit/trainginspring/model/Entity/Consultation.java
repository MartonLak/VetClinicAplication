package org.fasttrackit.trainginspring.model.Entity;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity(name = "consultations")
public class Consultation
{

    private @Id @GeneratedValue Long id;
    @Column
    private String recommendation;
    @Column
    private String comments;
    @Column
    private Date dateOfScheduling;
    @Column
    private Date dateOfConsulting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateOfScheduling() {
        return dateOfScheduling;
    }

    public void setDateOfScheduling(Date dateOfScheduling) {
        this.dateOfScheduling = dateOfScheduling;
    }

    public Date getDateOfConsulting() {
        return dateOfConsulting;
    }

    public void setDateOfConsulting(Date dateOfConsulting) {
        this.dateOfConsulting = dateOfConsulting;
    }
}
