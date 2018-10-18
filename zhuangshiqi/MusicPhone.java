package zhuangshiqi;

public class MusicPhone extends Phone {
    public void listenMusic() {
        System.out.println("听歌啊");
    }

    @Override
    public void call() {
        listenMusic();
        super.call();
    }
}
