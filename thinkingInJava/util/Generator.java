package thinkingInJava.util;

/**
 * 生成器
 * @param <T>
 */
public interface Generator<T> {
    T next();
}
