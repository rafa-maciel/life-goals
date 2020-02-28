package com.rmaciel.lifegoals.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @OneToMany(mappedBy = "goal", orphanRemoval = true, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();

    @JsonManagedReference
    public List<Task> getTasks() {
        return Collections.unmodifiableList(this.tasks);
    }

    public void add(Task... tasks) {
        if (this.tasks == null)
            this.tasks = new ArrayList<>();
        Stream.of(tasks).forEach(this.tasks::add);
    }

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

    public Date getDeadline() {
        return deadline;
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