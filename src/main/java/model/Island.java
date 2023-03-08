package model;

import abstraction.Animal;
import animals.Animals;
import factories.AnimalFactory;
import managers.SettingsManager;
import settings.IslandSettings;

import java.util.HashSet;

public class Island {
    public Cell[][] field;

    public void initializeIsland() {
        fillIslandWithCells();
        linkNeighboringCells();
        fillIslandWithAnimals();
    }

    private void fillIslandWithCells() {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        field = new Cell[islandSettings.length][islandSettings.height];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    private void linkNeighboringCells() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (i < field.length - 1) {
                    field[i][j].neighboringCells.add(field[i + 1][j]);
                    field[i + 1][j].neighboringCells.add(field[i][j]);
                }
                if (j < field[0].length - 1) {
                    field[i][j].neighboringCells.add(field[i][j + 1]);
                    field[i][j + 1].neighboringCells.add(field[i][j]);
                }
            }
        }
    }

    private void fillIslandWithAnimals() {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        for (Class<? extends Animal> animal : islandSettings.islandResidents) {
            HashSet<Animal> set = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                AnimalFactory factory = new AnimalFactory();
                set.add(factory.createAnimal(Animals.WOLF));
            }
            field[0][0].inhabitants.put(animal, set);
        }
    }

}
