package thinkingInJava.containers;

/**
 * 土拨鼠和预报系统
 * 土拨鼠
 */
public class Groundhog {
    protected int number;
    public Groundhog(int n) {
        number = n;
    }

    public String toString() {
        return "Groundhog #" + number;
    }
}
