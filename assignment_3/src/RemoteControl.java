import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private final Map<String, Command> commandMap = new HashMap<>();

    public void setCommand(String name, Command command) {
        commandMap.put(name, command);
    }

    public void executeCommand(String name) {
        Command command = commandMap.get(name);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Command not found: " + name);
        }
    }
}
