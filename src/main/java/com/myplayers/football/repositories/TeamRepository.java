package com.myplayers.football.repositories;

import com.myplayers.football.models.League;
import com.myplayers.football.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    // CODE
}
