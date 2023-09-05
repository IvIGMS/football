package com.myplayers.football.services;

import com.myplayers.football.models.Player;
import com.myplayers.football.models.Team;
import com.myplayers.football.repositories.PlayerRepository;
import com.myplayers.football.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    public ResponseEntity<Object> getPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.size()==0){
            // Retorno si aun no hay ningun jugador.
            return new ResponseEntity<>("No hay jugadores aun", HttpStatus.CONFLICT);
        }
        // Retorno si hay jugadores disponibles.
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    public ResponseEntity<Object> createPlayer(Player player) {
        playerRepository.save(player);
        boolean existsPlayer = playerRepository.existsById(player.getId());

        if (existsPlayer){
            return new ResponseEntity<>("Jugador creado correctamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("El jugador no se ha podido crear.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            // Retorno si existe el jugador
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            // Retorno si no existe ese jugador
            return new ResponseEntity<>("The player you are looking for doesn't exist", HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deletePlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        // Comprobamos si hay un jugador con ese Id
        if (player.isPresent()){
            // Borramos el jugador
            playerRepository.deleteById(id);
            // Comprobamos si se ha borrado
            player = playerRepository.findById(id);
            if (player.isPresent()){
                return new ResponseEntity<>("It was not possible to delete the player", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("The player has been deleted", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("The player you want to delete doesn't exist", HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> getPlayerByNumber(int number) {
        List<Player> currentPlayers = playerRepository.findByNumber(number);
        if (currentPlayers.size()==0){
            // Retorno si aun no hay ningun jugador.
            return new ResponseEntity<>("No hay jugadores aun con ese dorsal", HttpStatus.CONFLICT);
        }
        // Retorno si hay jugadores disponibles.
        return new ResponseEntity<>(currentPlayers, HttpStatus.OK);

    }

    public ResponseEntity<Object> getPlayerByCountry(String country) {
        List<Player> currentPlayers = playerRepository.findByCountry(country);
        if (currentPlayers.size()==0){
            // Retorno si aun no hay ningun jugador.
            return new ResponseEntity<>("No hay jugadores aun con ese pais", HttpStatus.CONFLICT);
        }
        // Retorno si hay jugadores disponibles.
        return new ResponseEntity<>(currentPlayers, HttpStatus.OK);

    }
}
