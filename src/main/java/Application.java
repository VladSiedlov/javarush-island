import animals.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import factories.AnimalFactory;
import managers.SettingsManager;
import model.Island;
import settings.IslandSettings;
import utils.RandomGenerator;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
//        IslandSettings islandSettings = new IslandSettings();
//        islandSettings.height = 20;
//        islandSettings.length = 100;
//        islandSettings.maxGrassOnCell = 200;
//        islandSettings.maxCellPopulation.put(Animals.WOLF, 30);
//        islandSettings.maxCellPopulation.put(Animals.SHEEP, 140);
//        islandSettings.islandResidents.add(Animals.WOLF);
//        islandSettings.islandResidents.add(Animals.SHEEP);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        mapper.writeValue(new File("src/main/resources/IslandSettings.json"), islandSettings);
//        System.out.println(islandSettings.maxCellPopulation.get(Animals.WOLF));
//
//        IslandSettings islandSettingsread = mapper.readValue(new File("src/main/resources/IslandSettings.json"), IslandSettings.class);
//        System.out.println(islandSettingsread.length);

//        AnimalsSettings animalsSettings = new AnimalsSettings();
//        AnimalSettings wolfSettings = new AnimalSettings();
//        wolfSettings.maxWeight = 50;
//        wolfSettings.maxSpeed = 3;
//        wolfSettings.eatProbability.put(Sheep.class, 70);
//        AnimalSettings sheepSettings = new AnimalSettings();
//        sheepSettings.maxWeight = 70;
//        sheepSettings.maxSpeed = 3;
//        sheepSettings.eatProbability.put(Grass.class, 100);
//        animalsSettings.animalSettingsMap.put(Wolf.class, wolfSettings);
//        animalsSettings.animalSettingsMap.put(Sheep.class, sheepSettings);
//        mapper.writeValue(new File("src/main/resources/AnimalsSettings.json"), animalsSettings);
//        SettingsManager settingsManager = SettingsManager.getSettings();
//        System.out.println(settingsManager.getAnimalsSettings());
//        System.out.println(new AnimalFactory().createAnimal(Animals.WOLF));
        Island island = new Island();
        island.initializeIsland();
        System.out.println("wow");
    }
}
