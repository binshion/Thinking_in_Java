package thinkingInJava.enumerated;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
