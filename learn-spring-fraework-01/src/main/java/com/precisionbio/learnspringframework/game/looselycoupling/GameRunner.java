package com.precisionbio.learnspringframework.game.looselycoupling;

/**
 * Game Runner - 느슨한 결합
 */
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
     * Game Runner 생성자
     * MarioGame 클래스의 인스턴스를 멤버로 받는다.
     * GameRunner 클래스의 코드 수정 없이는
     * 다른 유사한 유형의 게임을 실행 시킬 수 없는 MarioGame 전용 Runner가 된다.
     * 이러한 클래스들의 관계를 강한 결합을 가진다고 한다.
     * 
     * @param game
     */
    public GameRunner(GamingConsole game) {
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
