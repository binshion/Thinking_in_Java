package thinkingInJava.annotations.database;

@DBTable(name = "MEMBER")
public class Member {
    //快捷方式使用，如果注解中定义了value的元素且运用时该元素
    // 是唯一需要赋值的一个元素，那么无需使用名-值对的语法，只需
    // 在括号中给出value所需的值即可   @SQLString(30)
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;
    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
