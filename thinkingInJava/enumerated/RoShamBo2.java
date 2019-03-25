package thinkingInJava.enumerated;

import static thinkingInJava.enumerated.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    private Outcome vPAPER, vSCISSORS, vRock;
    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vRock = rock;
    }

    @Override
    public Outcome compete(RoShamBo2 competitor) {
        switch (competitor) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vRock;
        }
    }

    public static void main(String[] args){
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
