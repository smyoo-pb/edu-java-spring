package com.precisionbio.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.precisionbio.learnspringframework.game.looselycoupling.GameRunner;
import com.precisionbio.learnspringframework.game.looselycoupling.GamingConsole;

@Configuration
@ComponentScan("com.precisionbio.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(
                GamingAppLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
