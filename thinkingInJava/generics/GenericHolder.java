package thinkingInJava.generics;

public class GenericHolder<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args){
        GenericHolder<String> holder =
                new GenericHolder<>();

        holder.set("Item");

        //编译器自动插入转型操作
        String s = holder.get();
    }
}
