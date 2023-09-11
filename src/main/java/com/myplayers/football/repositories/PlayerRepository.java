package com.myplayers.football.repositories;

import com.myplayers.football.models.League;
import com.myplayers.football.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // CODE
    List<Player> findByNumber(int number);
    List<Player> findByCountry(String country);
    List<Player> findByPosition(String position);
}
