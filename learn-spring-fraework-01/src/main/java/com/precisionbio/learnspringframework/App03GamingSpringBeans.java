package com.precisionbio.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.precisionbio.learnspringframework.game.looselycoupling.GameRunner;
import com.precisionbio.learnspringframework.game.looselycoupling.GamingConsole;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(
                GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
