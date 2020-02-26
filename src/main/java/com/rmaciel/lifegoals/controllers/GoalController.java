package com.rmaciel.lifegoals.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.rmaciel.lifegoals.models.Goal;
import com.rmaciel.lifegoals.services.GoalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping()
    public List<Goal> all() {
        return goalService.findAll();
    }
    
    @PostMapping()
    public ResponseEntity<Goal> create(@Valid @RequestBody Goal goal) {
        return ResponseEntity.ok(goalService.save(goal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> update(@PathVariable(value = "id") Long id, @RequestBody Goal goal) {
        goal.setId(id);
        return ResponseEntity.ok(goalService.save(goal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Map<String, String> response = new HashMap<String, String>();
        Goal goal = new Goal();
        goal.setId(id);
        if (goalService.delete(goal)) {
            response.put("status", "success");
            response.put("message", "Goal has been deleted successfully");

            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Something went wrong and the goal has not been deleted");

            return ResponseEntity.status(500).body(response);
        }
    }
    
}
