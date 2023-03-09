package abstraction;

import model.Cell;

public abstract class Entity {
    public double weight;
    public abstract void reproduce();
    public abstract void die();
}
