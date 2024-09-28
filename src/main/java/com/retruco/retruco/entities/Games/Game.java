package com.retruco.retruco.entities.Games;

import jakarta.persistence.*;
import com.retruco.retruco.entities.Games.Deck;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Deck deck = new Deck();

    public Game(){
        this.deck.addCards();
    }
}
