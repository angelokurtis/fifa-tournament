package com.sensedia.labs.domain.match;

import com.sensedia.labs.domain.championship.Championship;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "championship_id", nullable = false)
    private Championship championship;
    private MatchTeams teams;
}

