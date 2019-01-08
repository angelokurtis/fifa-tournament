package com.sensedia.labs.infra.database.init;

import com.sensedia.labs.domain.player.Player;
import com.sensedia.labs.domain.player.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

class Players {

  private final Collection<Player> players = new ArrayList<>();

  Players() {
    final Player matheus = new Player();
    matheus.setName("Matheus");
    matheus.setRole(Role.USER);
    this.players.add(matheus);

    final Player tiago = new Player();
    tiago.setName("Tiago");
    tiago.setRole(Role.USER);
    this.players.add(tiago);

    final Player claudio = new Player();
    claudio.setName("Cláudio");
    claudio.setRole(Role.ADMIN);
    this.players.add(claudio);

    final Player caina = new Player();
    caina.setName("Cainã");
    caina.setRole(Role.USER);
    this.players.add(caina);
  }

  Optional<Player> random() {
    return this.players.stream().findAny();
  }

  Optional<Player> randomButOther(Player other) {
    final Collection<Player> copy = new ArrayList<>(this.players);
    copy.remove(other);
    return copy.stream().findAny();
  }

  Optional<Player> randomButOther(Collection<? extends Player> others) {
    final Collection<Player> copy = new ArrayList<>(this.players);
    copy.removeAll(others);
    return copy.stream().findAny();
  }

  Stream<Player> stream() {
    return this.players.stream();
  }

  Stream<Player> parallelStream() {
    return this.players.parallelStream();
  }

  void save(final CrudRepository<? super Player, Long> repository) {
    repository.saveAll(this.players);
  }
}
