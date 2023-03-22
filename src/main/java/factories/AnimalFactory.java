package factories;

import abstraction.Animal;
import animals.Animals;
import animals.carnivores.*;
import animals.herbivores.*;
import managers.SettingsManager;
import model.Cell;

public class AnimalFactory {
    public Animal createAnimal(Animals animal, Cell location) {
        Animal resultAnimal = null;
        switch (animal) {
            case WOLF -> resultAnimal = new Wolf();
            case BEAR -> resultAnimal = new Bear();
            case EAGLE -> resultAnimal = new Eagle();
            case FOX -> resultAnimal = new Fox();
            case SNAKE -> resultAnimal = new Snake();
            case SHEEP -> resultAnimal = new Sheep();
            case HORSE -> resultAnimal = new Horse();
            case DEER -> resultAnimal = new Deer();
            case RABBIT -> resultAnimal = new Rabbit();
            case MOUSE -> resultAnimal = new Mouse();
            case BOAR -> resultAnimal = new Boar();
            case BUFFALO -> resultAnimal = new Buffalo();
            case CATERPILLAR -> resultAnimal = new Caterpillar();
            case DUCK -> resultAnimal = new Duck();
            case GOAT -> resultAnimal = new Goat();
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
