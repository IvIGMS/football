package com.myplayers.football.models;

/*
* Con la clase DTO podemos replicar una entidad pero solo con los campos de la entidad que queramos
* sin necesidad de recurrir a uns hashmap en el service y usar un bucle for para rellenarlo.
* El ejemplo se ha hecho en el metodo getTeams() de TeamService.
* Esto se ha hecho para que solo nos salgan en el json los equipos y ya no nos salgan los jugadores
* dentro del equipo.
* */


public class TeamDTO {
    private Long id;
    private String name;
    private String presidentName;
    private String managerName;

    public TeamDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
