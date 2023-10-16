package basics;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.random.RandomGenerator;

public class SimpleArrays {
    private record Point(int x, int y){}

    public static void main(String[] args) {
        // Simple array
        var intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 2;
        }

        // Usage of Arrays
        var subArray = Arrays.copyOfRange(intArray, 2, 7);
        printSum(subArray);

        // Generate Array
        var doubleArray = new Double[11];
        Arrays.setAll(doubleArray, value -> Math.random());
        printElements(doubleArray);

        // Strings are array of character
        String hello = "Hello";
        char[] charArray = hello.toCharArray();
        charArray[1] = Character.toUpperCase(charArray[1]);
        System.out.println(charArray);

        // Array initialization and assignment
        String[] fruits = {"apple", "bananas", "oranges", "cherry"};
        int index = Arrays.binarySearch(fruits, "oranges");
        if (index >= 0) {
            System.out.printf("Found at index %d\n", index);
        }

        // Playground 2-dim array
        final int SIZE = 8;
        final RandomGenerator random = RandomGenerator.getDefault();
        char[][] playground = new char[SIZE][SIZE];
        applyToArrays(playground, ch -> '.');
        for (int i = 0; i < 5; i++) {
            do {
                Point p = new Point(random.nextInt(SIZE), random.nextInt(SIZE));
                if (playground[p.x][p.y] == '.') {
                    playground[p.x][p.y] = Character.forDigit(i + 1, 10);
                    break;
                }
            } while(true);
        }
        for (char[] line : playground) {
            System.out.println(line);
        }

        // Array of List (Nicht-rechteckige Arrays) Pascalsche Dreieck
        int[][] triangle = new int[7][];
        for (int i = 0; i < triangle.length; i++) {
            var line = new int[i+1];
            line[0] = 1;
            line[i] = 1;
            for (int j = 1; j < i; j++ ) {
                line[j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
            triangle[i] = line;
        }
        for (int i = 0; i < triangle.length; i++) {
            System.out.print(" ".repeat(2 * (triangle.length - i)));
            for (int v : triangle[i]) {
                System.out.printf("%3d ", v);
            }
            System.out.println();
        }
    }

    private static void printSum(int[] intArray) {
        int result = 0;
        // Use Iterator
        for (int j : intArray) {
            result += j;
        }
        System.out.println(result);
    }

    private static void printElements(Double...doubles) {
        for (int i = 0; i < doubles.length; i++) {
            if (i < doubles.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void applyToArrays(char[][] arrays, UnaryOperator<Character> func) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = func.apply(arrays[i][j]);
            }
        }
    }
}

