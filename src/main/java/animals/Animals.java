package animals;

import abstraction.Animal;
import animals.carnivores.Snake;
import animals.carnivores.Wolf;
import animals.herbivores.*;

public enum Animals {
    WOLF(Wolf.class),
    SHEEP(Sheep.class),
    SNAKE(Snake.class),
    HORSE(Horse.class),
    DEER(Deer.class),
    RABBIT(Rabbit.class),
    MOUSE(Mouse.class);


    private final Class<? extends Animal> animalClass;

    Animals(Class<? extends Animal> animalClass) {
        this.animalClass = animalClass;
    }

    public Class<? extends Animal> getAnimalClass() {
        return animalClass;
    }
}
