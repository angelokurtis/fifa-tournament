package com.sensedia.labs.domain.match;

import com.sensedia.labs.domain.player.Player;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Embeddable
public class HomePlayerTeam {
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "home_player_id")
    private Player player;
}
