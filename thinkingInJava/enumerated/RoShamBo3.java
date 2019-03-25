package thinkingInJava.enumerated;

import static thinkingInJava.enumerated.Outcome.*;

public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return DRAW;
                case ROCK:
                    return WIN;
                case SCISSPRS:
                    return LOSE;
            }
        }
    },
    SCISSPRS {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case SCISSPRS:
                    return DRAW;
                case ROCK:
                    return LOSE;
                case PAPER:
                    return WIN;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSPRS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };

    public abstract Outcome compete(RoShamBo3 it);

    public static void main(String[] args){
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
