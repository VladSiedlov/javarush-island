package abstraction;

import abstraction.interfaces.Breedable;
import abstraction.interfaces.Movable;
import animals.Animals;
import factories.AnimalFactory;
import managers.SettingsManager;
import model.Cell;
import settings.AnimalSettings;
import utils.RandomGenerator;

import java.util.Set;

public abstract class Animal extends Entity implements Movable, Breedable {
    public Cell location;
    public Animals enumValue;
    private boolean isBreadedThisTurn = false;

    public void move() {
        isBreadedThisTurn = false;
        AnimalSettings settings = SettingsManager.getSettings().
                getAnimalsSettings().
                getSettingsForAnimal(this.getClass());
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
    }

    public abstract void eat();

    @Override
    public void reproduce() {
        if (!isBreadedThisTurn) {
            breed();
        }
    }

    public void breed() {
        Set<Animal> mates = location.inhabitants.get(this.getClass());
        if (mates.size() > 1) {
            Animal mate = mates.iterator().next();
            if (!mate.isBreadedThisTurn) {
                mate.isBreadedThisTurn = true;
                AnimalFactory animalFactory = new AnimalFactory();
                animalFactory.createAnimal(enumValue, location);
            }
        }
        isBreadedThisTurn = true;
    }

    public void starve() {
        AnimalSettings settings = SettingsManager.getSettings().
                getAnimalsSettings().
                getSettingsForAnimal(this.getClass());
        weight = weight - (settings.maxWeight * RandomGenerator.getRandomDouble(0.3));
        if (weight < 0) {
            die();
        }
    }

    @Override
    public void die() {
        location.inhabitants.get(this.getClass()).remove(this);
    }
}
