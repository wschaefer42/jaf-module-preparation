package basics;

import java.util.Arrays;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class LoopSample {
    public static void main(String[] args) {
        RandomGenerator generator = RandomGenerator.getDefault();

        // While
        int counter  = 0;
        while (counter < 100) {
            counter += generator.nextInt(10);
        }
        println("While: %d", counter);

        // While forever
        while (true) {
            int value = generator.nextInt(10);
            if (value % 2 == 0) {
                continue;
            }
            counter += value;
            if (counter > 200) {
                break;
            }
        }
        println("Forever: %d", counter);

        // Do-while
        do {
            counter += generator.nextInt(100);
        } while (counter < 200);
        println("Do-while: %d", counter);

        // Classic for loop
        int[] intArray = new int[10];
        Arrays.setAll(intArray, v -> generator.nextInt(20));
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        println("Classic for: %d", sum);

        // For each
        sum = 0;
        for (int value : intArray) {
            sum += value;
        }
        println("Foreach: %d", sum);

        // Endless for
        int tries = 0;
        int number = generator.nextInt(5) + 1;
        for (;;) {
            System.out.print("Any number between 1-5 > ");
            int guess = new Scanner(System.in).nextInt();
            if (guess > 5) {
                System.out.println("Only number between 1 - 5 allow!");
                continue;
            }
            if (guess == number) {
                System.out.println("Great, you guess the number!");
                break;
            } else {
                if (++tries >= 3) {
                    System.out.println("Game over");
                    break;
                }
                System.out.println("Sorry wrong, try again");
            }
        }
    }

    private static void println(String msg, Object...args) {
        System.out.printf(msg, args);
        System.out.println();
    }
}
