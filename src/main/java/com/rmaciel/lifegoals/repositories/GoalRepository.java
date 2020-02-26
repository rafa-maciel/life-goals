package com.rmaciel.lifegoals.repositories;

import java.util.List;

import com.rmaciel.lifegoals.models.Goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

	List<Goal> findByTitleContains(String title);

}