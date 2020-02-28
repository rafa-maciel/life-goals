package com.rmaciel.lifegoals.controllers;

import java.util.List;

import javax.validation.Valid;

import com.rmaciel.lifegoals.models.Goal;
import com.rmaciel.lifegoals.models.Task;
import com.rmaciel.lifegoals.services.GoalService;
import com.rmaciel.lifegoals.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/goals/{goalId}/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private GoalService goalService;

    @GetMapping()
    public List<Task> findAllByGoal(@PathVariable(value = "goalId") Long goalId) {
        Goal goal = goalService.findById(goalId);
        return taskService.findByGoal(goal);
    }

    @PostMapping()
    public ResponseEntity<Task> create(@PathVariable(value = "goalId") Long goalId, @Valid @RequestBody Task task) {
        Goal goal = goalService.findById(goalId);
        task.setGoal(goal);
        return ResponseEntity.ok(taskService.save(task));
    }
    
    
}