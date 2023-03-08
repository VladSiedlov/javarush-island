package managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import settings.AnimalsSettings;
import settings.IslandSettings;

import java.io.File;
import java.io.IOException;

public class SettingsManager {
    private final String ANIMALS_SETTINGS_FILE_PATH = "src/main/resources/AnimalsSettings.json";
    private final String ISLAND_SETTINGS_FILE_PATH = "src/main/resources/IslandSettings.json";

    private static SettingsManager SETTINGS;
    private AnimalsSettings animalsSettings;
    private IslandSettings islandSettings;

    public AnimalsSettings getAnimalsSettings() {
        return animalsSettings;
    }

    public IslandSettings getIslandSettings() {
        return islandSettings;
    }

    private SettingsManager() {
        initializeSettings();
    }

    public static SettingsManager getSettings() {
        if (SETTINGS == null) {
            SETTINGS = new SettingsManager();
        }
        return SETTINGS;
    }

    private void initializeSettings() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            animalsSettings = mapper.readValue(new File(ANIMALS_SETTINGS_FILE_PATH), AnimalsSettings.class);
            islandSettings = mapper.readValue(new File(ISLAND_SETTINGS_FILE_PATH), IslandSettings.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
