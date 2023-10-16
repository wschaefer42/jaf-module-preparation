package generics;

public class TypedArray {
    private final Object[] list;
    private final Class<?> type;

    public TypedArray(int size, Class<?> type) {
        this.list = new Object[size];
        this.type = type;
    }

    public boolean set(int index, Object value) {
        if (type.isInstance(value)) {
            if (index >= 0 && index < list.length) {
                list[index] = value;
                return true;
            }
        } else {
            System.out.println("Invalid type " + value.getClass().getSimpleName());
        }
        return false;
    }

    public Object get(int index) {
        return list[index];
    }

    public int size() {
        return list.length;
    }

    public void printList() {
        for(Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
