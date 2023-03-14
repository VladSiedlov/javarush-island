package plants;

import abstraction.Entity;
import managers.SettingsManager;
import settings.IslandSettings;

public class Grass extends Entity {
    public int quantity;
    @Override
    public void reproduce() {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        weight = quantity * islandSettings.grassWeight;
    }
}
