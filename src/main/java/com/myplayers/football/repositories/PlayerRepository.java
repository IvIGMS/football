package com.myplayers.football.repositories;

import com.myplayers.football.models.League;
import com.myplayers.football.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // CODE
}
