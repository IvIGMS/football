package com.myplayers.football.controllers;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLeaguesById(@PathVariable Long id){
        return leagueService.getLeaguesById(id);
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<Object> createLeague(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "country") String country
    ){
        return leagueService.createLeague(name, country);
    }
}
