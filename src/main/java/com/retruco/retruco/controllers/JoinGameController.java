package com.retruco.retruco.controllers;

import com.retruco.retruco.entities.JoinGame;
import com.retruco.retruco.services.JoinGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/JoinGame")
@CrossOrigin(origins = "http://localhost:5173")
public class JoinGameController {
    @Autowired
    private JoinGameService joinGameService;

    @GetMapping
    public ResponseEntity<List<JoinGame>> getAllJoinGames() {
        List<JoinGame> joinGames = joinGameService.getAllJoinGames();
        return ResponseEntity.ok(joinGames);
    }

    @PostMapping
    public ResponseEntity<JoinGame> createJoinGame(@RequestBody JoinGame joinGame) {
        JoinGame createdJoinGame = joinGameService.createJoinGame(joinGame);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJoinGame);
    }
}
