package thinkingInJava;

public class Chess extends BoardGame{
    Chess(int i){
        super(i);
        System.out.println("Chess");
    }

    public static void main(String[] args) {
        Chess chess = new Chess(2);
    }
}


class Game{
    Game(int i) {
        System.out.println("Game");
    }
}

class BoardGame extends Game{
    BoardGame(int i){
        super(i);
        System.out.println("BoardGame");
    }
}
