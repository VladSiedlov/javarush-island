package factories;

import abstraction.Animal;
import animals.Animals;
import animals.carnivores.Snake;
import animals.carnivores.Wolf;
import animals.herbivores.*;
import managers.SettingsManager;
import model.Cell;

public class AnimalFactory {
    public Animal createAnimal(Animals animal, Cell location) {
        Animal resultAnimal = null;
        switch (animal) {
            case WOLF -> resultAnimal = new Wolf();
            case SHEEP -> resultAnimal = new Sheep();
            case SNAKE -> resultAnimal = new Snake();
            case HORSE -> resultAnimal = new Horse();
            case DEER -> resultAnimal = new Deer();
            case RABBIT -> resultAnimal = new Rabbit();
            case MOUSE -> resultAnimal = new Mouse();
        }
        resultAnimal.settings = SettingsManager.
                getSettings().
                getAnimalsSettings().
                getSettingsForAnimal(animal);
        resultAnimal.weight = resultAnimal.settings.maxWeight;
        resultAnimal.location = location;
        return resultAnimal;
    }
}
