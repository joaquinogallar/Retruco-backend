package com.retruco.retruco.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class JoinGame {
    @Id
    @GeneratedValue
    private Long id;

    private String image;
    private String rules;
    private String entry;
}
