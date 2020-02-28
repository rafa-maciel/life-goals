package com.rmaciel.lifegoals.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id", name = "goal_id", nullable = false)
    private Goal goal;

    @NotEmpty(message = "Title must be informed")
    private String title;

    @NotEmpty(message = "Title must be informed")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date createdOn = new Date();

    @Temporal(TemporalType.DATE)
    private Date deadline;

    @Enumerated(EnumType.STRING)
    private ActivityStatus status = ActivityStatus.WAITING;


    public Long getId() {
        return this.id;
    }
    
    @JsonManagedReference
    public Goal getGoal() {
        return this.goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public ActivityStatus getStatus() {
        return this.status;
    }

}