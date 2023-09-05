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

    public ResponseEntity<Object> createLeague(String name, String country) {
        League league = new League();
        league.setName(name);
        league.setCountry(country);
        leagueRepository.save(league);
        boolean existsLeague = leagueRepository.existsByName(name);

        if (existsLeague){
            return new ResponseEntity<>("Liga creada correctamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("La liga no se ha podido crear.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getLeaguesById(Long id) {
        Optional<League> league = leagueRepository.findById(id);
        if (league.isPresent()){
            // Retorno si hay ligas disponibles.
            return new ResponseEntity<>(league, HttpStatus.OK);

        } else {
            // Retorno si no existe esa liga
            return new ResponseEntity<>("The league you are looking for doesn't exist", HttpStatus.CONFLICT);
        }


    }
}