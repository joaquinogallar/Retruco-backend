package com.retruco.retruco.dtos;

import com.retruco.retruco.entities.Achievement;
import com.retruco.retruco.entities.Game;
import com.retruco.retruco.entities.Player;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private String nickname;
    private String country;
    private Integer wins;
    private Integer loses;
    private Integer streak;


    // Constructor que acepta un objeto Player
    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.surname = player.getSurname();
        this.nickname = player.getNickname();
        this.country = player.getCountry();
        this.wins = player.getWins();
        this.loses = player.getLoses();
        this.streak = player.getStreak();
    }
}
