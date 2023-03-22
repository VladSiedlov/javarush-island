package animals.herbivores;

import abstraction.Animal;
import abstraction.Entity;
import abstraction.Herbivore;
import animals.Animals;
import utils.RandomGenerator;

import java.util.Set;

public class Boar extends Herbivore {
    public Boar() {
        enumValue = Animals.BOAR;
    }

    @Override
    public void eat() {
        Set<Class<? extends Entity>> eatingTargets = settings.eatProbability.keySet();
        Class<? extends Entity> targetToEat = RandomGenerator.getRandomElementFromSet(eatingTargets);
        if (targetToEat.getName().equals("plants.Grass") ) {
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
