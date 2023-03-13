package abstraction;

import managers.SettingsManager;
import settings.AnimalSettings;

import java.util.Set;

public abstract class Carnivore extends Animal {
    @Override
    public void eat() {
        AnimalSettings settings = SettingsManager.getSettings().
                getAnimalsSettings().
                getSettingsForAnimal(this.getClass());
        Set<Class<? extends Entity>> eatingTargets = settings.eatProbability.keySet();
        Class<? extends Entity> targetToEat = eatingTargets.iterator().next();
        Set<? extends Entity> animalsForFood = location.inhabitants.get(targetToEat);
        if (!animalsForFood.isEmpty()) {
            animalsForFood.iterator().next().die();
            weight +=10; //kek
        }
    }
}
