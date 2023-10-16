package generics;

import java.util.function.IntFunction;

public class ObjectArray {
    private final Object[] list;

    public ObjectArray(int size) {
        list = new Object[size];
    }

    public int size() {
        return list.length;
    }

    public void set(int index, Object value) {
        list[index] = value;
    }

    public Object get(int index) {
        if (index >= 0 && index < size()) {
            return list[index];
        } else {
            return null;
        }
    }

    public void setAll(IntFunction<Object> func) {
        for (int i = 0; i < size(); i++) {
            list[i]  = func.apply(i);
        }
    }

    public void printList() {
        for(Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}

