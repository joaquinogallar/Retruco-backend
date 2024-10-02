package com.retruco.retruco.services;


import com.retruco.retruco.entities.JoinGame;
import com.retruco.retruco.repositories.JoinGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinGameService {
    @Autowired
    private JoinGameRepository joinGameRepository;

    public List<JoinGame> getAllJoinGames() {
        return joinGameRepository.findAll();
    }

    public JoinGame createJoinGame(JoinGame joinGame) {
        return joinGameRepository.save(joinGame);
    }
}
