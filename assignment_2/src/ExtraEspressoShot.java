public class ExtraEspressoShot extends CoffeeDecorator {
    public ExtraEspressoShot(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Extra Espresso Shot";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}
