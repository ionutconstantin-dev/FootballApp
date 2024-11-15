package com.football.FootballApp.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {


    private int id;
    private String name;
    private int age;
    private String club;

    public Player(int id, String name, int age, String club){
        this.id = id;
        this.name = name;
        this.age = age;
        this.club = club;
    }


}
