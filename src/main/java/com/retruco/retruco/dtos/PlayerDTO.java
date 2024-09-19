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
    private String email;
    private String nickname;
    private String phone;
    private String country;
    private String province;
    private String city;
    private LocalDate creationDate;
    private List<Player> friends;
    private Double balance;
    private Integer wins;
    private Integer loses;
    private Integer streak;
    private Integer maxStreak;
    private List<Game> games;
    private List<Achievement> achievements;

    // Constructor que acepta un objeto Player
    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.surname = player.getSurname();
        this.email = player.getEmail();
        this.nickname = player.getNickname();
        this.phone = player.getPhone();
        this.country = player.getCountry();
        this.province = player.getProvince();
        this.city = player.getCity();
        this.creationDate = player.getCreationDate();
        this.friends = player.getFriends();
        this.balance = player.getBalance();
        this.wins = player.getWins();
        this.loses = player.getLoses();
        this.streak = player.getStreak();
        this.maxStreak = player.getMaxStreak();
        this.games = player.getGames();
        this.achievements = player.getAchievements();
    }
}
