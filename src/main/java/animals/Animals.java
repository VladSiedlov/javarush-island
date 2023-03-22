package animals;

import abstraction.Animal;
import animals.carnivores.*;
import animals.herbivores.*;

public enum Animals {
    WOLF(Wolf.class),
    SHEEP(Sheep.class),
    SNAKE(Snake.class),
    HORSE(Horse.class),
    DEER(Deer.class),
    RABBIT(Rabbit.class),
    MOUSE(Mouse.class),
    BEAR(Bear.class),
    EAGLE(Eagle.class),
    FOX(Fox.class),
    BOAR(Boar.class),
    BUFFALO(Buffalo.class),
    CATERPILLAR(Caterpillar.class),
    DUCK(Duck.class),
    GOAT(Goat.class);

    private final Class<? extends Animal> animalClass;

    Animals(Class<? extends Animal> animalClass) {
        this.animalClass = animalClass;
    }

    public Class<? extends Animal> getAnimalClass() {
        return animalClass;
    }
}
