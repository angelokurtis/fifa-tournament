package com.sensedia.labs.infra.database.init;

import com.sensedia.labs.domain.championship.Championship;
import com.sensedia.labs.domain.match.*;
import com.sensedia.labs.domain.player.Player;
import com.sensedia.labs.domain.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class RandomMatches {

  private final Collection<Match> matches = new ArrayList<>();

  RandomMatches(Championships championships, Players players, Teams teams) {
    final Optional<Championship> championship = championships.findAny();
    players.parallelStream()
        .map(player -> {
          final Team team = teams.random().orElseThrow(InvalidAmountOfTeamsException::new);
          return new HomePlayerTeam(team, player);
        })
        .map(home -> {
          final Player player1 = home.getPlayer();
          final Team team1 = home.getTeam();

          final Player player2 = players.randomButOther(player1).orElseThrow(InvalidAmountOfPlayersException::new);
          final Team team2 = teams.randomButOther(team1).orElseThrow(InvalidAmountOfTeamsException::new);
          final VisitingPlayerTeam visiting = new VisitingPlayerTeam(team2, player2);

          return new MatchTeams(home, visiting);
        })
        .map(Match::new)
        .peek(match -> championship.ifPresent(match::setChampionship))
        .forEach(this.matches::add);
  }

  void save(MatchRepository repository) {
    repository.saveAll(this.matches);
  }
}
