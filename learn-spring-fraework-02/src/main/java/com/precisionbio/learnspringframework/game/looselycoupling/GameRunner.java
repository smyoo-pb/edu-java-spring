package com.precisionbio.learnspringframework.game.looselycoupling;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Game Runner - 느슨한 결합
 */
@Component
public class GameRunner {
    /**
     * GamingConsole interface
     * 다음 기능을 수행할 수 있다.
     * - up
     * - down
     * - left
     * - right
     */
    GamingConsole game;

    /**
     * Qualifier 어노테이션을 활용하여 주입할 객체를 선택할 수 있다.
     * 
     * @param game
     */
    public GameRunner(@Qualifier("PacMan") GamingConsole game) {
        this.game = game;
    }

    /**
     * run
     *
     * @return void run
     */
    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
