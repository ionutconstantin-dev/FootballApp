package com.football.FootballApp.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {


    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String club;

    public Player(int id, String firstName, String lastName, int age, String club) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.club = club;
    }


}
