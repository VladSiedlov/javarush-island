package model;

import abstraction.Animal;
import animals.Animals;
import managers.*;
import settings.IslandSettings;
import view.StatisticsPrinter;

import java.util.List;
import java.util.Set;

public class GameEngine {
    private Island island;

    public GameEngine() {
        island = new Island();
    }

    public void startGame() {
        island.initializeIsland();
//        int countdown = 10;
//        while (countdown > 0) {
//            makeMoves();
//            doEating();
//            doReproduction();
//            doStarving();
//            checkGameOver();
//            printStatistics();
//        }
        makeMoves();
    }


    public void makeMoves() {
        //MovingManager movingManager = new MovingManager();
        for (Cell[] column : island.field) {
            for (Cell cell : column) {
                for (Animals type : SettingsManager.getSettings().getIslandSettings().islandResidents) {
                    List<Animal> animals = cell.inhabitants.get(type.getAnimalClass());
                    for (int i = 0; i < animals.size(); i++) {
                        animals.get(i).move();
                    }
                    //TODO
                }
            }
        }
    }



    private void doEating() {
        EatingManager eatingManager = new EatingManager();
    }

    private void doReproduction() {
        BreedingManager breedingManager = new BreedingManager();
        GrowManager growManager = new GrowManager();
    }

    private void doStarving() {
        StarvingManager starvingManager = new StarvingManager();
    }

    private void checkGameOver() {
    }

    private void printStatistics() {
        StatisticsPrinter statisticsPrinter = new StatisticsPrinter();
    }
}
