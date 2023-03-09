package model;

import abstraction.Animal;
import plants.Grass;

import java.util.*;

public class Cell {
    Grass grass;
    List<Cell> neighboringCells = new ArrayList<>();
    Map<Class<? extends Animal>, Set<Animal>> inhabitants = new HashMap<>();
}
