package functional;

import java.util.Arrays;

public class FunctionalMain {
    public static void main(String[] args) {
        var fruitsOrigin = new String[]{"BAnana", "aPPles", "o ranges", "ananas"};
        var fruitsFormatted = formattingList(fruitsOrigin, v -> {
            String s = v.trim().toLowerCase();
            if (s.contains(" ")) {
                s = s.replaceAll("[ \t]+", "");
            }
            return s;
        });
        System.out.println(Arrays.toString(fruitsFormatted));
    }

    private static String[] formattingList(String[] list, Formatter<String> formatter) {
        var cloneList = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            cloneList[i] = formatter.format(list[i]);
        }
        return cloneList;
    }
}
