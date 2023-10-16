package generics;

import java.util.Comparator;
import java.util.Iterator;

public class GenericList<T> implements Iterable<T>{
    class GenericListIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < list.length;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) list[cursor++];
        }
    }

    private final Object[] list;

    public GenericList(int size) {
        list = new Object[size];
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericListIterator();
    }

    public int size() {
        return list.length;
    }

    public void set(int index, T value) {
        list[index] = value;
    }

    public boolean contains(T value, Comparator<T> comparator) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (comparator.compare(get(i), value) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) list[index];
    }
}
