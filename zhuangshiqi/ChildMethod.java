package zhuangshiqi;

public class ChildMethod extends ParentMethod {
    public String get2(){
        return "get2";
    }

    public static void main(String[] args){
        ChildMethod c = new ChildMethod();
        c.getFilter();
    }
}
