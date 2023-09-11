package com.myplayers.football.controllers;

import com.myplayers.football.models.League;
import com.myplayers.football.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
public class LeagueController {
    @Autowired
    LeagueService leagueService;
    // READ
    @GetMapping
    public ResponseEntity<Object> getLeagues(){
        return leagueService.getLeagues();
    }
    // READ_ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getLeaguesById(@PathVariable Long id){
        return leagueService.getLeagueById(id);
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<Object> createLeague(@RequestBody League league){
        return leagueService.createLeague(league);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteLeague(@PathVariable Long id){
        return leagueService.deleteLeague(id);
    }
}
