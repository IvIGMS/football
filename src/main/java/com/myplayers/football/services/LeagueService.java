package com.myplayers.football.services;

import com.myplayers.football.models.League;
import com.myplayers.football.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LeagueService {
    @Autowired
    LeagueRepository leagueRepository;

    public ResponseEntity<Object> getLeagues() {
        List<League> leagues = leagueRepository.findAll();
        if (leagues.size()==0){
            // Retorno si aun no hay ninguna liga.
            return new ResponseEntity<>("No hay ligas aun", HttpStatus.CONFLICT);
        }
        // Retorno si hay ligas disponibles.
        return new ResponseEntity<>(leagues, HttpStatus.OK);
    }

    public ResponseEntity<Object> createLeague(League league) {
        leagueRepository.save(league);
        boolean existsLeague = leagueRepository.existsById(league.getId());

        if (existsLeague){
            return new ResponseEntity<>("Liga creada correctamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("La liga no se ha podido crear.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getLeagueById(Long id) {
        Optional<League> league = leagueRepository.findById(id);
        if (league.isPresent()){
            // Retorno si hay ligas disponibles.
            return new ResponseEntity<>(league, HttpStatus.OK);

        } else {
            // Retorno si no existe esa liga
            return new ResponseEntity<>("The league you are looking for doesn't exist", HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deleteLeague(Long id) {
        Optional<League> league = leagueRepository.findById(id);
        // Comprobamos si hay una liga con ese Id
        if (league.isPresent()){
            // Borramos la liga
            leagueRepository.deleteById(id);
            // Comprobamos si se ha borrado
            league = leagueRepository.findById(id);
            if (league.isPresent()){
                return new ResponseEntity<>("It was not possible to delete the league", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("The league has been deleted", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("The league you want to delete doesn't exist", HttpStatus.CONFLICT);
        }
    }
}