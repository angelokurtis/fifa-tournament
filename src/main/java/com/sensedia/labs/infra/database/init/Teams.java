package com.sensedia.labs.infra.database.init;

import com.sensedia.labs.domain.team.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class Teams {

  private final Collection<Team> teams = new ArrayList<>();

  Teams() {
    final Team juventus = new Team();
    juventus.setName("Juventus");
    juventus.setStars(5.0);
    juventus.setCountry("Italy");
    juventus.setLeague("Serie A TIM");
    this.teams.add(juventus);

    final Team schalke = new Team();
    schalke.setName("FC Schalke 04");
    schalke.setStars(4.5);
    schalke.setCountry("Germany");
    schalke.setLeague("Bundesliga");
    this.teams.add(schalke);

    final Team brighton = new Team();
    brighton.setName("Brighton");
    brighton.setStars(4.0);
    brighton.setCountry("England");
    brighton.setLeague("Premier League");
    this.teams.add(brighton);

    final Team verona = new Team();
    verona.setName("Chievo Verona");
    verona.setStars(4.0);
    verona.setCountry("Italy");
    verona.setLeague("Serie A TIM");
    this.teams.add(verona);

    final Team valladolid = new Team();
    valladolid.setName("Real Valladolid");
    valladolid.setStars(3.5);
    valladolid.setCountry("Spain");
    valladolid.setLeague("LaLiga Santander");
    this.teams.add(valladolid);
  }

  Optional<Team> random() {
    return this.teams.stream().findAny();
  }

  Optional<Team> randomButOther(Team other) {
    final Collection<Team> copy = new ArrayList<>(this.teams);
    copy.remove(other);
    return copy.stream().findAny();
  }

  Optional<Team> randomButOther(Collection<? extends Team> others) {
    final Collection<Team> copy = new ArrayList<>(this.teams);
    copy.removeAll(others);
    return copy.stream().findAny();
  }

  void save(CrudRepository<Team, Long> repository) {
    repository.saveAll(this.teams);
  }
}
