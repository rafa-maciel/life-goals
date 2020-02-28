package com.rmaciel.lifegoals.services;

import java.util.List;

import com.rmaciel.lifegoals.models.Goal;
import com.rmaciel.lifegoals.models.Task;
import com.rmaciel.lifegoals.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public boolean delete(Task task) {
        Task taskUpdated = taskRepository.findById(task.getId()).orElse(null);
        if (taskUpdated != null) {
            taskRepository.delete(taskUpdated);
            return true;
        }
        return false;
    }


    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    public List<Task> findByGoal(Goal goal) {
        return taskRepository.findByGoal(goal);
    }

}