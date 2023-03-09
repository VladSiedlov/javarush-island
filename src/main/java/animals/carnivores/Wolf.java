package animals.carnivores;

import abstraction.Carnivore;
import animals.Animals;
import managers.SettingsManager;
import model.Cell;
import settings.AnimalSettings;
import utils.RandomGenerator;

public class Wolf extends Carnivore {

    @Override
    public void eat() {

    }

    @Override
    public void move() {
        AnimalSettings settings = SettingsManager.getSettings().
                getAnimalsSettings().
                getSettingsForAnimal(this.getClass());
        int maxSpeed = settings.maxSpeed;
        int currentSpeed = RandomGenerator.getRandomInt(maxSpeed);
        for (int i = 0; i < currentSpeed; i++) {
            int directionIndex = RandomGenerator.getRandomInt(location.neighboringCells.size());
            Cell direction = location.neighboringCells.get(directionIndex);
            int maxPopulationOnCell = SettingsManager.getSettings().getIslandSettings().maxCellPopulation.get(Animals.WOLF);
            if (direction.inhabitants.get(this.getClass()).size() < maxPopulationOnCell) {
                location.inhabitants.get(this.getClass()).remove(this);
                System.out.println(this + "moved from " + location + " to " + direction);
                location = direction;
                location.inhabitants.get(this.getClass()).add(this);
            }
        }
    }

    @Override
    public void reproduce() {
        breed();
    }
    @Override
    public void breed() {

    }

    @Override
    public void starve() {

    }


    @Override
    public void die() {

    }
}
