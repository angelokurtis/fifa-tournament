package com.sensedia.labs.domain.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sensedia.labs.domain.match.Match;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "match_player",
            joinColumns = @JoinColumn(name = "match_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    private List<Match> matches;
}


