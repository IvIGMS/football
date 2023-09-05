package com.myplayers.football.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "president_name")
    private String presidentName;
    @Column(name = "manager_name")
    private String managerName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "league_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private League league;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;
}
