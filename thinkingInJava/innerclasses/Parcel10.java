package thinkingInJava.innerclasses;

public class Parcel10 {
    //此处参数说是要定义为final，但是不添加final好像也没有编译错误
    public Destination destination(String dest, float price) {
        return new Destination(){
            private int cost;
            //Instance initialization for each Object:
            {
                cost = Math.round(price);
                if(cost > 100) {
                    System.out.println("Over budget!");
                }
            }
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args){
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Binshion", 101.395f);
    }
}
