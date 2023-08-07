package com.precisionbio.learnspringframework.game.looselycoupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Component 또한 동일하게 Primary를 통하여
 * 주입 할 객체에 대한 우선순위 설정이 가능하다.
 */
@Component
@Primary
public class MarioGame implements GamingConsole {
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go into a hole");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Accelerate");
    }
}
