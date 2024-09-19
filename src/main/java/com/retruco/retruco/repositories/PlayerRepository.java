package com.retruco.retruco.repositories;

import com.retruco.retruco.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
