package abstraction;

public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        if (location.grass.quantity > 0) {
            weight += 5;
            location.grass.quantity -= 5;
        }
    }
}