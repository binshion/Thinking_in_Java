package thinkingInJava.interfaces;

import com.sun.org.apache.bcel.internal.generic.RET;

class A {
    interface B {
        void f();
    }

    public class BImp implements B {
        public void f() {

        }
    }

    private class BImp2 implements B {
        @Override
        public void f() {

        }
    }

    interface C {
        void f();
    }

    class CImp implements C {
        @Override
        public void f() {

        }
    }

    private class CImp2 implements C {
        @Override
        public void f() {

        }
    }

    private interface D {
        void f();
    }

    private class DImp implements D {
        @Override
        public void f() {

        }
    }

    public class DImp2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImp2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }

    interface E {
        interface G {
            void f();
        }

        public interface H {
            void f();
        }

        void g();
    }
}

public class NestingInterfaces {
    public class BImp implements A.B {
        @Override
        public void f() {

        }
    }

    class CImp implements A.C {
        public void f(){

        }
    }

//    class DImp implements A.D {
//
//    }

    class EImp implements A.E {
        @Override
        public void g() {

        }
    }

    class EGImp implements A.E

            .G{
        @Override
        public void f() {

        }
    }

    class EImp2 implements A.E {
        @Override
        public void g() {

        }

        class EG implements A.E

                .G {
            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
