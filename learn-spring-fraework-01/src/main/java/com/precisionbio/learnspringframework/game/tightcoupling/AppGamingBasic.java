package com.precisionbio.learnspringframework.game.tightcoupling;

/**
 * 강한 결합 예제
 */
public class AppGamingBasic {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        // Game Runner가 MarioGame 클래스와 강하게 결합되어 있다.
        // GameRunner의 코드를 변경하지 않는 한 SuperContraGame을 실행할 수 없다.
        // var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();

    }
}
