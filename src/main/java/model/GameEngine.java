package model;

import abstraction.Animal;
import animals.Animals;
import managers.*;
import settings.IslandSettings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameEngine {
    private final Island island;

    public GameEngine() {
        island = new Island();
    }

    public void startGame() {
        island.initializeIsland();
        startGrassGrowing();
        for (int i = 0; i < 10; i++) {
            makeMoves();
            doEating();
            doReproduction();
            doStarving();
            checkGameOver();
            printStatistics();
        }
    }


    public void makeMoves() {
        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
                    Set<Animal> animals = cell.inhabitants.get(type.getAnimalClass());
                    Set<Animal> copy = new HashSet<>(animals);
                    for (Animal animal : copy) {
                        animal.move();
                    }
                }
            }
        }
    }


    private void doEating() {
        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
                    Set<Animal> animals = cell.inhabitants.get(type.getAnimalClass());
                    Set<Animal> copy = new HashSet<>(animals);
                    for (Animal animal : copy) {
                        animal.eat();
                    }
                }
            }
        }
    }

    private void doReproduction() {
        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
                    Set<Animal> animals = cell.inhabitants.get(type.getAnimalClass());
                    Set<Animal> copy = new HashSet<>(animals);
                    for (Animal animal : copy) {
                        animal.reproduce();
                    }
                }
            }
        }
    }

    private void doStarving() {
        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
                    Set<Animal> animals = cell.inhabitants.get(type.getAnimalClass());
                    Set<Animal> copy = new HashSet<>(animals);
                    for (Animal animal : copy) {
                        animal.starve();
                    }
                }
            }
        }
    }

    private void checkGameOver() {
    }

    private void printStatistics() {
        Map<Animals, Integer> population = new HashMap<>();
        for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
            population.put(type, 0);
        }

        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
                    Set<Animal> animals = cell.inhabitants.get(type.getAnimalClass());
                    population.replace(type, population.get(type) + animals.size());
                }
            }
        }

        System.out.println(population);
    }

    private void startGrassGrowing() {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(4);
        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                scheduledThreadPoolExecutor.scheduleAtFixedRate(cell.grass, 0, islandSettings.grassReproductionPeriod, TimeUnit.MILLISECONDS);
            }
        }
    }
}
