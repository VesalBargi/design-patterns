import java.util.ArrayList;

public class Min implements Formula {
    public double calculate(ArrayList<Cell> cells) {
        double min = Double.MAX_VALUE;
        for (Cell cell : cells) {
            min = Math.min(min, cell.getValue());
        }
        return min;
    }
}
