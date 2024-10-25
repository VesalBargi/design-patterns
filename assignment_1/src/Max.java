import java.util.ArrayList;

public class Max implements Formula {
    public double calculate(ArrayList<Cell> cells) {
        double max = Double.MIN_VALUE;
        for (Cell cell : cells) {
            max = Math.max(max, cell.getValue());
        }
        return max;
    }
}
