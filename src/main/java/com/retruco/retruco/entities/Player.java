package com.retruco.retruco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public Player(String name, String surname, String email, String nickname, String password, String phone, String country, String province, String city) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.country = country;
        this.province = province;
        this.city = city;
        this.creationDate = LocalDate.now();
        this.friends = new ArrayList<>();
        this.balance = 0.0;
        this.victories = 0;
        this.defeats = 0;
        this.streak = 0;
        this.maxStreak = 0;
        this.achievements = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    /**
     * @author Joaquin Ogallar (joaquinnogallar@gmail.com)
     * @version 1
     *
     * Calculate winrate % with wins and losses
     *
     * @return
     */
    public Float calculateWinrate() {
        int totalGames = getTotalGames();
        if (totalGames == 0) {
            return 0.0F;
        }
        return (float) (victories / totalGames * 100);
    }

    public Integer getTotalGames() {
        return victories + defeats;
    }
}
