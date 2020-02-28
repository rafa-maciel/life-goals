package com.rmaciel.lifegoals.repositories;

import java.util.List;

import com.rmaciel.lifegoals.models.ActivityStatus;
import com.rmaciel.lifegoals.models.Goal;
import com.rmaciel.lifegoals.models.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByGoal(Goal goal);
    public List<Task> findByGoalAndStatus(Goal goal, ActivityStatus status);
}