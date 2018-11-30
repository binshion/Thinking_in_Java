package thinkingInJava.innerclasses;
//调用基类构造器

public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            public int value(){
                return super.value() * 47;
            }
        };  //此处需要分号
    }

    public static void main(String[] args){
        Parcel8 p = new Parcel8();

        //只需简单传递合适的参数给基类的构造器即可
        //尽管Wrapping只是一个具体实现的普通类，但它被其导出类当做公共接口来使用
        Wrapping w = p.wrapping(10);
    }
}
