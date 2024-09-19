package com.retruco.retruco.controllers;

import com.retruco.retruco.entities.Player;
import com.retruco.retruco.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(playerDetails.getName());
            player.setSurname(playerDetails.getSurname());
            player.setEmail(playerDetails.getEmail());
            player.setNickname(playerDetails.getNickname());
            player.setPhone(playerDetails.getPhone());
            player.setCountry(playerDetails.getCountry());
            player.setProvince(playerDetails.getProvince());
            player.setCity(playerDetails.getCity());
            return playerRepository.save(player);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }
}
