package thinkingInJava.enumerated;

/**
 * enum中添加方法：
 *  必须在实例序列最后添加一个分号
 *  必须先定义enum实例再定义方法或属性
 */
public enum OzWitch {
    //Instances must be defined first, before methods.
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by interence, but missing");

    private String description;

    //构造器为包访问或私有访问权限
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
