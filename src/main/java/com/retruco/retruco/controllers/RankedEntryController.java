package com.retruco.retruco.controllers;

import com.retruco.retruco.entities.Player;
import com.retruco.retruco.entities.RankedEntry;
import com.retruco.retruco.services.RankedEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<RankedEntry> createRankedEntry(@RequestBody RankedEntry rankedEntry) {
        RankedEntry createdRankedEntry = rankedEntryService.createRankedEntry(rankedEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRankedEntry);
    }
}
