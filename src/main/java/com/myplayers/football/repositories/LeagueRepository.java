package com.myplayers.football.repositories;

import com.myplayers.football.models.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {
    // CODE
    public boolean existsByName(String name);
}
