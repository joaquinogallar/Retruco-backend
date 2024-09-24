package com.retruco.retruco.services;

import com.retruco.retruco.dtos.PlayerDTO;
import com.retruco.retruco.entities.Player;
import com.retruco.retruco.exceptions.PlayerNotFoundException;
import com.retruco.retruco.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(PlayerDTO::new)
                .toList();
    }

    public PlayerDTO getPlayerById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
        return new PlayerDTO(player);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
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

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
