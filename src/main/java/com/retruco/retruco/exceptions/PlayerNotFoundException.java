package com.retruco.retruco.exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Player with id " + id + " not found");
    }
}
