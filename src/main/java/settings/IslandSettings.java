package settings;

import animals.Animals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IslandSettings {
    public int height;
    public int length;
    public int maxGrassQuantityOnCell;
    public double grassWeight;
    public int grassReproductionPeriod;
    public int simulationIterationsCount;
    public Set<Animals> islandResidents = new HashSet<>();
    public Map<Animals, Integer> maxCellPopulation = new HashMap<>();

}
