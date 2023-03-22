package model;

import abstraction.Animal;
import animals.Animals;
import factories.AnimalFactory;
import factories.GrassFactory;
import managers.SettingsManager;
import settings.IslandSettings;
import utils.RandomGenerator;
import java.util.HashSet;
import java.util.Set;

public class Island {
    private final IslandSettings islandSettings;
    public Cell[][] field;

    public Island() {
        islandSettings = SettingsManager.getSettings().getIslandSettings();
    }

    public void initializeIsland() {
        fillIslandWithCells();
        linkNeighboringCells();
        fillIslandWithAnimals();
        fillIslandWithGrass();
    }

    private void fillIslandWithCells() {
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
        for (Cell[] cells : field) {
            for (int j = 0; j < field[0].length; j++) {
                fillOneCellWithAnimals(cells[j]);
            }
        }
    }

    private void fillOneCellWithAnimals(Cell cell) {
        AnimalFactory factory = new AnimalFactory();
        for (Animals animal : islandSettings.islandResidents) {
            Set<Animal> list = new HashSet<>();
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
        for (Cell[] cells : field) {
            for (int j = 0; j < field[0].length; j++) {
                cells[j].grass = grassFactory.createGrass();
            }
        }
    }

    public IslandSettings getIslandSettings() {
        return islandSettings;
    }
}
