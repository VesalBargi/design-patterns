import java.util.ArrayList;

public class Cell implements Observer {
    private String name;
    private double value;
    private Formula formula;
    private ArrayList<Cell> dependents = new ArrayList<>();
    private ArrayList<Cell> observers = new ArrayList<>();

    public Cell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        if (formula != null) {
            return formula.calculate(dependents);
        }
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        notifyObservers();
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public ArrayList<Cell> getObservers() {
        return observers;
    }

    public void addDependent(Cell dependent) {
        dependents.add(dependent);
        dependent.addObserver(this);
    }

    public void addObserver(Cell observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Cell observer : observers) {
            observer.update();
        }
    }

    @Override
    public void update() {
        if (formula != null) {
            setValue(formula.calculate(dependents));
        }
    }
}
