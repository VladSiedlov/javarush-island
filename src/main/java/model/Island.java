package model;

import abstraction.Animal;
import animals.Animals;
import factories.AnimalFactory;
import factories.GrassFactory;
import managers.SettingsManager;
import plants.Grass;
import settings.IslandSettings;
import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Island {
    public Cell[][] field;

    public void initializeIsland() {
        fillIslandWithCells();
        linkNeighboringCells();
        fillIslandWithAnimals();
        fillIslandWithGrass();
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
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                fillOneCellWithAnimals(field[i][j]);
            }
        }
    }

    private void fillOneCellWithAnimals(Cell cell) {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        AnimalFactory factory = new AnimalFactory();
        for (Animals animal : islandSettings.islandResidents) {
            List<Animal> list = new ArrayList<>();
            int maxAnimalPopulation = islandSettings.maxCellPopulation.get(animal);
            int animalsCountOnCell = RandomGenerator.getRandomInt(maxAnimalPopulation);
            for (int i = 0; i < animalsCountOnCell; i++) {
                list.add(factory.createAnimal(animal, cell));
            }
            cell.inhabitants.put(animal.getAnimalClass(), list);
        }
    }

    private void fillIslandWithGrass() {
        GrassFactory grassFactory = new GrassFactory();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j].grass = grassFactory.createGrass();
            }
        }
    }

}
