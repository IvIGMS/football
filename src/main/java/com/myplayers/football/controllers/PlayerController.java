package com.myplayers.football.controllers;

import com.myplayers.football.models.Player;
import com.myplayers.football.models.Team;
import com.myplayers.football.services.PlayerService;
import com.myplayers.football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;
    // READ
    @GetMapping
    public ResponseEntity<Object> getPlayers(){
        return playerService.getPlayers();
    }
    // READ_ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlayersById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }
    // CREATE
    @PostMapping("/create")
    public ResponseEntity<Object> createPlayers(@RequestBody Player player){
        return playerService.createPlayer(player);
    }
    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePlayer(@PathVariable Long id){
        return playerService.deletePlayer(id);
    }
}
