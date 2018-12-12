package com.sensedia.labs.domain.match;

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
    private Integer stars;
    private String country;
    private String league;
}

