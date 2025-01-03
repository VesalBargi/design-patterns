import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {
    private String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    public void write(String text) {
        text += "\n";
        try {
            Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read() {
        String data = "";
        try {
            data = new String(
                    Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
