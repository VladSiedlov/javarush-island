package plants;

import abstraction.Entity;
import managers.SettingsManager;
import settings.IslandSettings;

public class Grass extends Entity implements Runnable {
    public int quantity;
    @Override
    public void reproduce() {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        weight = quantity * islandSettings.grassWeight;
    }

    @Override
    public void run() {
        reproduce();
    }
}
