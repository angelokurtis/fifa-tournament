package com.sensedia.labs.domain.match;

import com.sensedia.labs.domain.player.Player;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Embeddable
public class VisitingPlayerTeam {
    @ManyToOne
    @JoinColumn(name = "visiting_team_id")
    private Team team;
    @ManyToMany(mappedBy = "matches")
    private List<Player> players;
}
