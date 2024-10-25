import java.util.ArrayList;

public class Average implements Formula {
    public double calculate(ArrayList<Cell> cells) {
        double sum = 0;
        for (Cell cell : cells) {
            sum += cell.getValue();
        }
        if (cells.isEmpty()) {
            return 0;
        } else {
            return sum / cells.size();
        }
    }
}
