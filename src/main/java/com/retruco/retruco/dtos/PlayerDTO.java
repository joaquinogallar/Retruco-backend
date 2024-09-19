package com.retruco.retruco.dtos;

import com.retruco.retruco.entities.Achievement;
import com.retruco.retruco.entities.Game;
import com.retruco.retruco.entities.Player;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
}
