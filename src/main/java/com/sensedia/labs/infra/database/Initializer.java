package com.sensedia.labs.infra.database;

import com.sensedia.labs.domain.player.Player;
import com.sensedia.labs.domain.player.PlayerRepository;
import com.sensedia.labs.domain.player.Role;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Component
public class Initializer implements ApplicationRunner {

    private final PlayerRepository playerRepository;

    public Initializer(final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public void run(final ApplicationArguments args) {
        final Player tiago = new Player();
        tiago.setName("Tiago");
        tiago.setRole(Role.USER);
        this.playerRepository.save(tiago);

        final Player claudio = new Player();
        claudio.setName("Cláudio");
        claudio.setRole(Role.ADMIN);
        this.playerRepository.save(claudio);

        final Player caina = new Player();
        caina.setName("Cainã");
        caina.setRole(Role.USER);
        this.playerRepository.save(caina);
    }
}
