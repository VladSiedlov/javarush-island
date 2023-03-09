package model;

import abstraction.Animal;
import plants.Grass;

import java.util.*;

public class Cell {
    Grass grass;
    public List<Cell> neighboringCells = new ArrayList<>();
    public Map<Class<? extends Animal>, List<Animal>> inhabitants = new HashMap<>();
}
