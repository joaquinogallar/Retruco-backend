package com.retruco.retruco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class History {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate gameDate;
    private String mode;
    private String player;
    private String result;
}
