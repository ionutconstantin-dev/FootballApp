package com.football.FootballApp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private int id;
    private String name;
    private int age;
    private String nationality;

    public Player() {
    }

    public Player(int id, String name, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
}
