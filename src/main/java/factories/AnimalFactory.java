package factories;

import abstraction.Animal;
import animals.Animals;
import animals.carnivores.Wolf;
import animals.herbivores.Sheep;
import managers.SettingsManager;
import settings.AnimalSettings;

public class AnimalFactory {
    public Animal createAnimal(Animals animal) {
        Animal resultAnimal = null;
        switch (animal) {
            case WOLF -> resultAnimal = new Wolf();
            case SHEEP -> resultAnimal = new Sheep();
        }
        AnimalSettings resultAnimalSettings = SettingsManager.
                getSettings().
                getAnimalsSettings().
                getSettingsForAnimal(resultAnimal.getClass());

        resultAnimal.weight = resultAnimalSettings.maxWeight;
        return resultAnimal;
    }
}
