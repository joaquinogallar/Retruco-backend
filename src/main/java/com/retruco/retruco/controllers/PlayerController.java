package com.retruco.retruco.controllers;

import com.retruco.retruco.dtos.PlayerDTO;
import com.retruco.retruco.entities.Player;
import com.retruco.retruco.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:5173") // necesario para permitirle al front consumier nuestros endpoints
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDTO> playerDTOs = players.stream()
                .map(PlayerDTO::new)
                .toList();
        
        return ResponseEntity.ok(playerDTOs);
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        PlayerDTO playerDTO = new PlayerDTO(player);
        return playerDTO;
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
