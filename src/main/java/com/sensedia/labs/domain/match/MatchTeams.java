package com.sensedia.labs.domain.match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MatchTeams {

    private HomePlayerTeam home;
    private VisitingPlayerTeam visiting;

}
