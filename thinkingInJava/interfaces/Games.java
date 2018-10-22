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
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}

public class Games {
    private static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move());
    }

    public static void main(String[] args){
        System.out.println("************" + Checkers.class.getName() + "***********");
        playGame(new CheckersFactory());
        System.out.println("************" + Chess.class.getName() + "**************");
        playGame(new ChessFactory());
    }
}
