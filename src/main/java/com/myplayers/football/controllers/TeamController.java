package com.myplayers.football.controllers;

import com.myplayers.football.models.Team;
import com.myplayers.football.services.LeagueService;
import com.myplayers.football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;
    // READ
    @GetMapping
    public ResponseEntity<Object> getTeams(){
        return teamService.getTeams();
    }
    // READ_ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTeamsById(@PathVariable Long id){
        return teamService.getTeamById(id);
    }
    // CREATE
    @PostMapping("/create")
    public ResponseEntity<Object> createTeams(@RequestBody Team team){
        System.out.println(team.getName());
        System.out.println(team.getManagerName());
        System.out.println(team.getPresidentName());
        System.out.println(team.getLeague());

        return teamService.createTeam(team);
    }
    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTeam(@PathVariable Long id){
        return teamService.deleteTeam(id);
    }
}
