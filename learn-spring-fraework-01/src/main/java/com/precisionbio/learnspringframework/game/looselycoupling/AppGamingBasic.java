package com.precisionbio.learnspringframework.game.looselycoupling;

/**
 * 느슨한 결합 예제
 */
public class AppGamingBasic {
    public static void main(String[] args) {
        // var game = new MarioGame();
        // GamingConsole Interface를 생성하여 느슨한 결합 구조를 사용하였다.
        // GameRunner의 코드 수정 없이도 MarioGame, SuperContraGame 모두 수행할 수 있게 되었다.
        // var game = new SuperContraGame();
        var game = new PacMan();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
