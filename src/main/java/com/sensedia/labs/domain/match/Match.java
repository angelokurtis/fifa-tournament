package com.sensedia.labs.domain.match;

import com.sensedia.labs.domain.championship.Championship;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "championship_id", nullable = false)
    private Championship championship;
    private MatchTeams teams;

    public Match(final MatchTeams teams) {
        this.teams = teams;
    }
}

