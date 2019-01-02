package com.sensedia.labs.domain.team;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double stars;
    private String country;
    private String league;
}

