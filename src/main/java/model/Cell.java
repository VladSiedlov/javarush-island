package model;

import abstraction.Animal;

import java.util.*;

public class Cell {
    List<Cell> neighboringCells = new ArrayList<>();
    Map<Class<? extends Animal>, Set<Animal>> inhabitants = new HashMap<>();
}
