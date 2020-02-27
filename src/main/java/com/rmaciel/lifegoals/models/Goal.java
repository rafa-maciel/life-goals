package com.rmaciel.lifegoals.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title must be informed")
    private String title;

    @NotNull(message = "Description must be informed")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date createdOn = Calendar.getInstance().getTime();

    @Temporal(TemporalType.DATE)
    private Date deadline;

    private String whyToDevelop;
    private String howToDevelop;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public String getWhyToDevelop() {
        return this.whyToDevelop;
    }

    public void setWhyToDevelop(String whyToDevelop) {
        this.whyToDevelop = whyToDevelop;
    }

    public String getHowToDevelop() {
        return this.howToDevelop;
    }

    public void setHowToDevelop(String howToDevelop) {
        this.howToDevelop = howToDevelop;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Goal other = (Goal) obj;
            if (other.id.equals(this.id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.title;
    }
    
}