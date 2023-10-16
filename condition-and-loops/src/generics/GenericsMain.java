package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class GenericsMain {
    private static final String text = """
    Dies ist ein Text mit vielen Worten
    aber keinen Inhalt, um    aus einer Anzahl von Wörtern
    zufällig ein Wort auszuwählen
    """.strip();

    public static void main(String[] args) {
        RandomGenerator generator = RandomGenerator.getDefault();
        String[] words = text.split("[ ,.\t\n\r]+");

        // Object list
        ObjectArray objectArray = new ObjectArray(10);
        objectArray.setAll(v -> words[generator.nextInt(words.length)] );
        for (int i = 0; i < objectArray.size(); i++) {
            String s = (String) objectArray.get(i);
            System.out.printf("Object value at %d: %s\n", i, s.toLowerCase());
        }
        objectArray.set(1, 10);
        objectArray.printList();

        // Typed list
        TypedArray typedArray = new TypedArray(10, String.class);
        for (int i = 0; i < typedArray.size(); i++) {
            typedArray.set(i, words[generator.nextInt(words.length)]);
        }
        typedArray.set(1, 10);
        typedArray.printList();

        // Generic list
        GenericList<String> genericList = new GenericList<>(10);
        for (int i = 0; i < genericList.size(); i++) {
            for (int tries = 0; tries < words.length; tries++) {
                String word = words[generator.nextInt(words.length)];
                if (!genericList.contains(word, String::compareToIgnoreCase)) {
                    genericList.set(i, word);
                    break;
                }
            }
        }
        // For-each using Iterator/Iterable
        for (String s : genericList) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Collection list
        List<String> collectionList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String word = words[generator.nextInt(words.length)];
            if (!collectionList.contains(word)) {
                collectionList.add(word);
            }
        }
        collectionList.forEach(v -> System.out.print(v + " "));
        System.out.println();
    }
}
