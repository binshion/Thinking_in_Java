package Decorate;

public class IphoneX implements Phone{
    @Override
    public void call() {
        System.out.println("给周围的人打电话");
    }
}
