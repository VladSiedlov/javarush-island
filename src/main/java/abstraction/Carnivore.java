package abstraction;
import utils.RandomGenerator;
import java.util.Set;

public abstract class Carnivore extends Animal {
    @Override
    public void eat() {
        Set<Class<? extends Entity>> eatingTargets = settings.eatProbability.keySet();
        Class<? extends Entity> targetToEat = RandomGenerator.getRandomElementFromSet(eatingTargets);
        Set<? extends Entity> animalsForFood = location.inhabitants.get(targetToEat);
        if (!animalsForFood.isEmpty()) {
            Animal animalForFood = (Animal) RandomGenerator.getRandomElementFromSet(animalsForFood);
            weight = Math.min(weight + animalForFood.weight, settings.maxWeight);
            animalForFood.die();
        }
    }
}
