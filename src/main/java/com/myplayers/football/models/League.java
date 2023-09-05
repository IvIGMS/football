package com.myplayers.football.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Team> teams;
}


