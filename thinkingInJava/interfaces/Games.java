package thinkingInJava.interfaces;

/*
A game framework using Factory Methods.
@Author: Binshion Liu
@Date: 2018-10-22
 */

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    

    @Override
    public boolean move() {
        return false;
    }
}

public class Games {
}
