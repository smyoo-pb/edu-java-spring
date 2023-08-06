package com.precisionbio.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.precisionbio.learnspringframework.game.looselycoupling.GameRunner;
import com.precisionbio.learnspringframework.game.looselycoupling.GamingConsole;
import com.precisionbio.learnspringframework.game.looselycoupling.PacMan;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole game() {
        return new PacMan();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }
}
