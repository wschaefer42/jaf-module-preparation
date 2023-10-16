
package basics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class ConditionSamples {
    public static void main(String[] args) {
        // If-else-if-else
        int month = LocalDate.now().getMonthValue();
        String season;
        if (month < 4) {
            season = "Winter";
        } else if (month < 7) {
            season = "Spring";
        } else if (month < 10) {
            season = "Sommer";
        } else {
            season = "Autumn";
        }
        System.out.printf("Current season is: %s\n", season);

        System.out.println(month < 7 ? "Spring Semester" : "Fall Semester");

        // Elvis operator
        String semester = Arrays.asList("Winter", "Spring").contains(season) ? "Spring" : "Fall";
        System.out.printf("Semester is: %s\n", semester);

        // Classic switch
        switch(month) {
            case 1, 2, 3:
                season = "Winter";
                break;
            case 4, 5, 6:
                season = "Frühling";
                break;
            case 7, 8, 9:
                season = "Sommer";
                break;
            case 10:
            case 11:
            case 12:
                season = "Herbst";
                break;
            default:
                season = "???";
        }
        System.out.printf("Aktuelle Jahreszeit ist %s\n", season);

        // New Switch (when)
        var randomSeason = switch (new Random().nextInt(12) + 1) {
            case 1, 2, 3 -> "Winter";
            case 4, 5, 6 -> "Spring";
            case 7, 8, 9 -> "Sommer";
            default -> "Autumn";
        };
        System.out.printf("Random season is: %s\n", randomSeason);

        // Equals of string, == compares Object addresses
        if (!(randomSeason.equals("Winter") || randomSeason.equals("Spring"))) {
            System.out.println("Go for skiing");
        }
    }
}
