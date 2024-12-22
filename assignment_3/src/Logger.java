import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private static final String LOG_FILE = "actions.log";

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logAction(String action) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(action + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
