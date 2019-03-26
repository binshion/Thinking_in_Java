package thinkingInJava.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  //Applies to classes only. 此外可以逗号分隔指定多个值。如果运用所有类型，可省去@Target注解，但这不常见
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
