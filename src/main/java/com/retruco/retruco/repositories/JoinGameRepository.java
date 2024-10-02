package com.retruco.retruco.repositories;

import com.retruco.retruco.entities.JoinGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinGameRepository extends JpaRepository<JoinGame, Long> {
}