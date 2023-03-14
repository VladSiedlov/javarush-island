package abstraction;

public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        if (location.grass.weight > 0) {
            double grassAmountWantToEat = settings.maxWeight - weight;
            if (location.grass.weight > grassAmountWantToEat) {
                weight += grassAmountWantToEat;
                location.grass.weight -= grassAmountWantToEat;
            } else {
                weight += location.grass.weight;
                location.grass.weight = 0;
            }
        }
    }
}