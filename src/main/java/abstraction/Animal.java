package abstraction;

import abstraction.interfaces.Breedable;
import abstraction.interfaces.Movable;
import animals.Animals;
import factories.AnimalFactory;
import managers.SettingsManager;
import model.Cell;
import settings.AnimalSettings;
import settings.IslandSettings;
import utils.RandomGenerator;

import java.util.Set;

public abstract class Animal extends Entity implements Movable, Breedable {
    public AnimalSettings settings;
    public Cell location;
    public Animals enumValue;
    private boolean isBreadedThisTurn = false;

    public void move() {
        int maxSpeed = settings.maxSpeed;
        int currentSpeed = RandomGenerator.getRandomInt(maxSpeed + 1);
        for (int i = 0; i < currentSpeed; i++) {
            int directionIndex = RandomGenerator.getRandomInt(location.neighboringCells.size());
            Cell direction = location.neighboringCells.get(directionIndex);
            int maxPopulationOnCell = SettingsManager.getSettings().getIslandSettings().maxCellPopulation.get(enumValue);
            if (direction.inhabitants.get(this.getClass()).size() < maxPopulationOnCell) {
                location.inhabitants.get(this.getClass()).remove(this);
                location = direction;
                location.inhabitants.get(this.getClass()).add(this);
            }
        }
        isBreadedThisTurn = false; //reset breed flag
    }

    public abstract void eat();

    @Override
    public void reproduce() {
        if (!isBreadedThisTurn) {
            breed();
        }
    }

    public void breed() {
        IslandSettings islandSettings = SettingsManager.getSettings().getIslandSettings();
        int maxPopulationOnSell = islandSettings.maxCellPopulation.get(this.enumValue);
        Set<Animal> breedingMates = location.inhabitants.get(this.getClass());
        if (breedingMates.size() > 1 && breedingMates.size() < maxPopulationOnSell) {
            Animal mate = RandomGenerator.getRandomElementFromSet(breedingMates);
            if (mate != this && !mate.isBreadedThisTurn) {
                mate.isBreadedThisTurn = true;
                if (RandomGenerator.getRandomInt(10) > 7) {
                    AnimalFactory animalFactory = new AnimalFactory();
                    breedingMates.add(animalFactory.createAnimal(enumValue, location));
                }
            }
        }
        isBreadedThisTurn = true;
    }

    public void starve() {
        weight = weight - (settings.maxWeight * RandomGenerator.getRandomDouble(0.3));
        if (weight < 0) {
            die();
        }
    }

    public void die() {
        location.inhabitants.get(this.getClass()).remove(this);
    }
}
