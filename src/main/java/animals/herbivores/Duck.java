package animals.herbivores;

import abstraction.Animal;
import abstraction.Entity;
import abstraction.Herbivore;
import animals.Animals;
import plants.Grass;
import utils.RandomGenerator;

import java.util.Set;

public class Duck extends Herbivore {
    public Duck() {
        enumValue = Animals.DUCK;
    }

    @Override
    public void eat() {
        Set<Class<? extends Entity>> eatingTargets = settings.eatProbability.keySet();
        Class<? extends Entity> targetToEat = RandomGenerator.getRandomElementFromSet(eatingTargets);
        if (targetToEat.isAssignableFrom(Grass.class)) {
            super.eat();
        } else {
            Set<? extends Entity> animalsForFood = location.inhabitants.get(targetToEat);
            if (!animalsForFood.isEmpty()) {
                Animal animalForFood = (Animal) RandomGenerator.getRandomElementFromSet(animalsForFood);
                weight = Math.min(weight + animalForFood.weight, settings.maxWeight);
                animalForFood.die();
            }
        }
    }
}
