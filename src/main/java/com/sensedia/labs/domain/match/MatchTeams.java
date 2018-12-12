package com.sensedia.labs.domain.match;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class MatchTeams {

    private HomePlayerTeam home;
    private VisitingPlayerTeam visiting;

}
