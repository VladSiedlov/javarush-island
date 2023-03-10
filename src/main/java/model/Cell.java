package model;

import abstraction.Animal;
import plants.Grass;

import java.util.*;

public class Cell {
    public Grass grass;
    public List<Cell> neighboringCells = new ArrayList<>();
    public Map<Class<? extends Animal>, Set<Animal>> inhabitants = new HashMap<>();
}
