package Decorate;

public class MusicPhone extends PhoneDecorate {
    public MusicPhone(Phone phone){
        super(phone);
    }

    public void listenMusic(){
        System.out.println("听音乐");
    }

    @Override
    public void call() {

        super.call();
        listenMusic();
    }
}
