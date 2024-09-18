package com.retruco.retruco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String nickname;

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    private String password;

    private String phone;
    private String country;
    private String province;
    private String city;

    private LocalDate creationDate;

    @ManyToMany
    private List<Player> friends;

    @Setter(AccessLevel.NONE)
    private Double balance;
    private Integer victories;
    private Integer defeats;
    private Integer streak;
    private Integer maxStreak;

    @OneToMany
    private List<Game> games;

    @ManyToMany
    private List<Achievement> achievements;
}
