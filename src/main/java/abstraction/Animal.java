package abstraction;

import abstraction.interfaces.Breedable;
import abstraction.interfaces.Movable;
import model.Cell;

public abstract class Animal extends Entity implements Movable, Breedable {
    public Cell location;
    public abstract void eat();
    public abstract void move();

    public abstract void breed();

    public abstract void starve();

}
