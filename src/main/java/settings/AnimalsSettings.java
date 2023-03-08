package settings;

import abstraction.Animal;

import java.util.HashMap;
import java.util.Map;


public class AnimalsSettings {
    public Map<Class<? extends Animal>, AnimalSettings> animalSettingsMap = new HashMap<>();

    public AnimalSettings getSettingsForAnimal(Class<? extends Animal> animal) {
        return animalSettingsMap.get(animal);
    }
}
