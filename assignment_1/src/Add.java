import java.util.ArrayList;

public class Add implements Formula {
    public double calculate(ArrayList<Cell> cells) {
        double sum = 0;
        for (Cell cell : cells) {
            sum += cell.getValue();
        }
        return sum;
    }
}
