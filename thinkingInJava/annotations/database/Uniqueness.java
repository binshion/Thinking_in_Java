package thinkingInJava.annotations.database;

/**
 * 使用注解时，更改某个默认的注解值
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
