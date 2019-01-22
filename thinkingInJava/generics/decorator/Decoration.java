package thinkingInJava.generics.decorator;

class Basic {
    private String value;

    public void set(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic {
    protected Basic basic;
    public Decorator(Basic basic) {
        this.basic = basic;
    }

    public void set(String value) {
        basic.set(value);
    }

    public String get() {
        return basic.get();
    }
}

public class Decoration {
}
