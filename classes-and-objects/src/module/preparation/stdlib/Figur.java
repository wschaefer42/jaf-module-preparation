package module.preparation.stdlib;

import java.util.Random;

public class Figur {
    private final double radius = new Random().nextDouble(100.0);

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
