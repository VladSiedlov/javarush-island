package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static int getRandomInt(int max) {
        return threadLocalRandom.nextInt(max);
    }

    public static double getRandomDouble(double max) {
        return threadLocalRandom.nextDouble(max);
    }
}
