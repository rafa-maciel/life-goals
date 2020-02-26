package com.rmaciel.lifegoals.services;

import java.util.List;

import com.rmaciel.lifegoals.models.Goal;
import com.rmaciel.lifegoals.repositories.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    public List<Goal> findByTitle(String title) {
        return goalRepository.findByTitleContains(title);
    }

    public Goal findById(Long id) {
        return goalRepository.findById(id).get();
    }

    public boolean delete(Goal goal) {
        Goal goalUpdated = goalRepository.findById(goal.getId()).orElse(null);
        if (goalUpdated == null)
            return false;

        goalRepository.delete(goalUpdated);
        return true;
    }

}