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

    public void addFriend(Long userId, Long friendId) {
        // verificar si el usuario está intentando agregarse a sí mismo como amigo
        if (userId.equals(friendId)) {
            throw new IllegalArgumentException("You cannot add yourself as a friend.");
        }

        // obtener los jugadores (usuario y amigo)
        Player player = playerRepository.findById(userId)
                .orElseThrow(() -> new PlayerNotFoundException(userId));
        Player friend = playerRepository.findById(friendId)
                .orElseThrow(() -> new PlayerNotFoundException(friendId));

        // Verificar si ya son amigos
        if (!player.getFriends().contains(friend)) {
            player.getFriends().add(friend);
            playerRepository.save(player);
        }
    }

    public List<PlayerDTO> getAllFriends(Long userId) {
        Player user = playerRepository.findById(userId)
                .orElseThrow(() -> new PlayerNotFoundException(userId));

        List<Player> friends = user.getFriends();

        return friends.stream()
                .map(PlayerDTO::new)
                .toList();
    }

    public void removeFriend(Long userId, Long friendId) {
        // obtener los jugadores (usuario y amigo)
        Player player = playerRepository.findById(userId)
                .orElseThrow(() -> new PlayerNotFoundException(userId));
        Player friend = playerRepository.findById(friendId)
                .orElseThrow(() -> new PlayerNotFoundException(friendId));

        player.getFriends().remove(friend);
    }

}
