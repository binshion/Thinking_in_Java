package zhuangshiqi;

public class GiveTimePhone extends MusicPhone {
    public void currentTime() {
        System.out.println("当前时间是：" + System.currentTimeMillis());
    }

    @Override
    public void call() {
        super.call();

        currentTime();
    }
}
