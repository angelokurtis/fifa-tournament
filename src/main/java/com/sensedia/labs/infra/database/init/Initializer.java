package com.sensedia.labs.infra.database.init;

import com.sensedia.labs.domain.championship.ChampionshipRepository;
import com.sensedia.labs.domain.match.MatchRepository;
import com.sensedia.labs.domain.player.PlayerRepository;
import com.sensedia.labs.domain.team.TeamRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Component
public class Initializer implements ApplicationRunner {

  private final ChampionshipRepository championshipRepository;
  private final MatchRepository matchRepository;
  private final PlayerRepository playerRepository;
  private final TeamRepository teamRepository;

  public Initializer(final ChampionshipRepository championshipRepository, final MatchRepository matchRepository, final PlayerRepository playerRepository, final TeamRepository teamRepository) {
    this.championshipRepository = championshipRepository;
    this.matchRepository = matchRepository;
    this.playerRepository = playerRepository;
    this.teamRepository = teamRepository;
  }

  @Override
  @Transactional
  public void run(final ApplicationArguments args) {
    final Players players = new Players();
    players.save(this.playerRepository);

    final Teams teams = new Teams();
    teams.save(this.teamRepository);

    final Championships championships = new Championships();
    championships.save(this.championshipRepository);

    final RandomMatches matches = new RandomMatches(championships, players, teams);
    matches.save(this.matchRepository);
  }
}
