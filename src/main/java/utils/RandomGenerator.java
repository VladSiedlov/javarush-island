package utils;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static int getRandomInt(int max) {
        return threadLocalRandom.nextInt(max);
    }

    public static double getRandomDouble(double max) {
        return threadLocalRandom.nextDouble(max);
    }

    public static <T> T getRandomElementFromSet(Set<T> animals) {
        return animals.stream().
                skip(threadLocalRandom.nextInt(animals.size())).
                findAny().
                get();
    }
}
