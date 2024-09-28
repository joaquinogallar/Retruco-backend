package com.retruco.retruco.services;

import com.retruco.retruco.entities.Player;
import com.retruco.retruco.entities.RankedEntry;
import com.retruco.retruco.repositories.RankedEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankedEntryService {
    @Autowired
    private RankedEntryRepository rankedEntryRepository;

    public List<RankedEntry> getAllRankedEntries() {
        return rankedEntryRepository.findAll();
    }

    public RankedEntry createRankedEntry(RankedEntry rankedEntry) {
        return rankedEntryRepository.save(rankedEntry);
    }
}
