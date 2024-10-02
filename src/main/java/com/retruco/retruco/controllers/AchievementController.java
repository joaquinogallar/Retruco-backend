package com.retruco.retruco.controllers;

import com.retruco.retruco.entities.Achievement;
import com.retruco.retruco.services.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Achievement")
@CrossOrigin(origins = "http://localhost:5173")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;


    @GetMapping
    public ResponseEntity<List<Achievement>> getAllAchievements(){
        List<Achievement> achievements = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievements);
    }

    @PostMapping
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement){
        Achievement createdAchievement = achievementService.createAchievement(achievement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAchievement);
    }
}
