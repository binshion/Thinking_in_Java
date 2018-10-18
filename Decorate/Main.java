package Decorate;

public class Main {
    public static void main(String[] args) {
       Phone phone = new IphoneX();
       phone = new MusicPhone(phone);
       phone = new GiveCurrentTimePhone(phone);
       phone.call();
    }
}
