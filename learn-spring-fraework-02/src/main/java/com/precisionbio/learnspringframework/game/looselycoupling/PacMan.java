package com.precisionbio.learnspringframework.game.looselycoupling;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Component 또한 동일하게 Qualifier를 통하여
 * 주입 할 객체에 대한 별칭(?) 설정이 가능하다.
 */
@Component
@Qualifier("PacMan")
public class PacMan implements GamingConsole {

    public void up() {
        System.out.println("PacMan: Up");
    }

    public void down() {
        System.out.println("PacMan: Down");
    }

    public void left() {
        System.out.println("PacMan: Left");
    }

    public void right() {
        System.out.println("PacMan: Right");
    }

}
