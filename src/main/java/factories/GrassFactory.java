package factories;

import managers.SettingsManager;
import model.Cell;
import plants.Grass;
import settings.IslandSettings;
import utils.RandomGenerator;

public class GrassFactory {
    public Grass createGrass() {
        Grass grass = new Grass();
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        grass.quantity = RandomGenerator.getRandomInt(islandSettings.maxGrassQuantityOnCell);
        grass.weight = islandSettings.grassWeight * grass.quantity;
        return grass;
    }
}
