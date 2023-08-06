package com.precisionbio.learnspringfraework;

public class AppGamingBasic {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();

    }
}
