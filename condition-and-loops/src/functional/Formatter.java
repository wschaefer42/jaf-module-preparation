package functional;

@FunctionalInterface
public interface Formatter<T> {
    T format(T value);
}
