package settings;

import abstraction.Entity;
import java.util.HashMap;
import java.util.Map;


public class AnimalSettings {
    public double maxWeight;
    public int maxSpeed;
    public Map<Class<? extends Entity>, Integer> eatProbability = new HashMap<>();
}
