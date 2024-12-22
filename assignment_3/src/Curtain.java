public class Curtain extends Device {
    public Curtain(String name) {
        super(name);
    }

    public void open() {
        performAction("Opened");
    }

    public void close() {
        performAction("Closed");
    }

    @Override
    void performAction(String action) {
        Logger.getInstance().logAction(name + " Curtain " + action);
    }
}
