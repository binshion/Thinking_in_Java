package thinkingInJava.util.atunit;

import java.lang.annotation.*;

/**
 * 元注解：
 *  @Target 定义注解应用于什么地方，例如是一个方法或一个域
 *  @Retention 定义该注解在哪一个级别可用，如源代码中SOURCE，类文件中CLASS或者运行时RUNTIME
 *  注解中一般会包含一些元素以表示某些值。
 *  没有元素的注解称之为 标记注解，如当前的@Test
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
