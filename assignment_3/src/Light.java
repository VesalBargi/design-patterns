public class Light extends Device {
    public Light(String name) {
        super(name);
    }

    public void turnOn() {
        performAction("Turned On");
    }

    public void turnOff() {
        performAction("Turned Off");
    }

    @Override
    void performAction(String action) {
        Logger.getInstance().logAction(name + " Light " + action);
    }
}
