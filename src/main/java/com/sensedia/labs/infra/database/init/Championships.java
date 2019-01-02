package com.sensedia.labs.infra.database.init;

import com.sensedia.labs.domain.championship.Championship;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class Championships {

  private final Collection<Championship> championships = new ArrayList<>();

  Championships() {
    final Championship championship = new Championship();
    championship.setName("Copa Sensedia");
    this.championships.add(championship);
  }

  Optional<Championship> findAny() {
    return this.championships.stream().findAny();
  }

  void save(CrudRepository<Championship, Long> repository) {
    repository.saveAll(this.championships);
  }
}
