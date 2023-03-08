package factories;

import managers.SettingsManager;
import plants.Grass;
import settings.IslandSettings;

public class GrassFactory {
    public Grass createGrass() {
        Grass grass = new Grass();
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        grass.quantity = islandSettings.maxGrassOnCell;
        return grass;
    }
}
