package animals;

import abstraction.Animal;
import animals.carnivores.Wolf;
import animals.herbivores.Sheep;

public enum Animals {
    WOLF(Wolf.class),
    SHEEP(Sheep.class);

    public final Class<? extends Animal> animalClass;

    Animals(Class<? extends Animal> animalClass) {
        this.animalClass = animalClass;
    }
}
