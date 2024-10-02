package com.retruco.retruco.controllers;

import com.retruco.retruco.entities.History;
import com.retruco.retruco.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/History")
@CrossOrigin("http://localhost:5173")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<History>> getHistory(){
        List<History> historyList = historyService.getHistory();
        return ResponseEntity.ok(historyList);
    }

    @PostMapping
    public ResponseEntity<History> createHistory(@RequestBody History history){
        History createdHistory = historyService.createHistory(history);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHistory);
    }
}
