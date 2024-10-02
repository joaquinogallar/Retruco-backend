package com.retruco.retruco.services;

import com.retruco.retruco.entities.History;
import com.retruco.retruco.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getHistory(){
        return historyRepository.findAll();
    }

    public History createHistory(History history){
        return historyRepository.save(history);
    }
}
