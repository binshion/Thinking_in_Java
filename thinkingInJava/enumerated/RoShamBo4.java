package thinkingInJava.enumerated;

public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSORS, competitor);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(ROCK, competitor);
        }
    },
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSORS, competitor);
        }
    };

    Outcome compete(RoShamBo4 loser, RoShamBo4 it) {
        return (it == this) ? Outcome.DRAW : (it == loser) ? Outcome.WIN : Outcome.LOSE;
    }

    public static void main(String[] args){
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
