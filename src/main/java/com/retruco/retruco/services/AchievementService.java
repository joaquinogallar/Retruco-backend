package com.retruco.retruco.services;

import com.retruco.retruco.entities.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import com.retruco.retruco.repositories.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public List<Achievement> getAllAchievements(){
        return achievementRepository.findAll();
    }

    public Achievement createAchievement(Achievement achievement){
        return achievementRepository.save(achievement);
    }
}
