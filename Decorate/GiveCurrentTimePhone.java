package Decorate;

public class GiveCurrentTimePhone extends PhoneDecorate {
    public GiveCurrentTimePhone(Phone phone){
        super(phone);
    }

    public void currentTime(){
        System.out.println("当前时间：" + System.currentTimeMillis());
    }

    @Override
    public void call() {
        currentTime();
        super.call();


    }
}
