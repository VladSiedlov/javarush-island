package model;

import abstraction.Animal;
import animals.Animals;
import managers.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameEngine {
    private Island island;

    public GameEngine() {
        island = new Island();
    }

    public void startGame() {
        island.initializeIsland();
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
}
