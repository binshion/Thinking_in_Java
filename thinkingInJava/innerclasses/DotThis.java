package thinkingInJava.innerclasses;

/**
 * 使用外部类的没办法自垢面紧跟圆点和this
 */

public class DotThis {
    void fun(){
        System.out.println("DotThis.fun()");
    }

    public class Inner{
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args){
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().fun();
    }
}
