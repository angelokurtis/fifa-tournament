package com.sensedia.labs.domain.match;

import com.sensedia.labs.domain.player.Player;
import com.sensedia.labs.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class HomePlayerTeam {
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "home_player_id")
    private Player player;
}
