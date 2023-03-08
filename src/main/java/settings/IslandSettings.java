package settings;

import abstraction.Animal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IslandSettings {
    public int height;
    public int length;
    public int maxGrassOnCell;
    public Set<Class<? extends Animal>> islandResidents = new HashSet<>();
    public Map<Class<? extends Animal>, Integer> maxCellPopulation = new HashMap<>();
}
