package com.retruco.retruco.repositories;

import com.retruco.retruco.entities.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}