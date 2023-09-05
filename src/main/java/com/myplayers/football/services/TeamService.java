package com.myplayers.football.services;

import com.myplayers.football.models.Team;
import com.myplayers.football.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public ResponseEntity<Object> getTeams() {
        List<Team> teams = teamRepository.findAll();
        if (teams.size()==0){
            // Retorno si aun no hay ningun equipo.
            return new ResponseEntity<>("No hay equipos aun", HttpStatus.CONFLICT);
        }
        // Retorno si hay equipos disponibles.
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    public ResponseEntity<Object> createTeam(Team team) {
        teamRepository.save(team);
        boolean existsTeam = teamRepository.existsById(team.getId());

        if (existsTeam){
            return new ResponseEntity<>("Equipo creado correctamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("El equipo no se ha podido crear.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()){
            // Retorno si existe el equipo
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            // Retorno si no existe ese equipo
            return new ResponseEntity<>("The team you are looking for doesn't exist", HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deleteTeam(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        // Comprobamos si hay un equipo con ese Id
        if (team.isPresent()){
            // Borramos el equipo
            teamRepository.deleteById(id);
            // Comprobamos si se ha borrado
            team = teamRepository.findById(id);
            if (team.isPresent()){
                return new ResponseEntity<>("It was not possible to delete the team", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("The team has been deleted", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("The team you want to delete doesn't exist", HttpStatus.CONFLICT);
        }
    }
}