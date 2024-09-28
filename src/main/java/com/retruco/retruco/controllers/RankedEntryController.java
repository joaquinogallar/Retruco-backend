package com.retruco.retruco.controllers;

import com.retruco.retruco.entities.RankedEntry;
import com.retruco.retruco.services.RankedEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RankedEntries")
@CrossOrigin(origins = "http://localhost:5173")
public class RankedEntryController {
    @Autowired
    private RankedEntryService rankedEntryService;

    @GetMapping
    public ResponseEntity<List<RankedEntry>> getAllRankedEntries(){
        List<RankedEntry> rankedEntries = rankedEntryService.getAllRankedEntries();
        return ResponseEntity.ok(rankedEntries);
    }
}
