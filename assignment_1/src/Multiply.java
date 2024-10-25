import java.util.ArrayList;

public class Multiply implements Formula {
    public double calculate(ArrayList<Cell> cells) {
        double product = 1;
        for (Cell cell : cells) {
            product *= cell.getValue();
        }
        return product;
    }
}
