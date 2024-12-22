public class Fan extends Device {
    public Fan(String name) {
        super(name);
    }

    public void setSpeed(String speed) {
        performAction("Set to " + speed + " Speed");
    }

    @Override
    void performAction(String action) {
        Logger.getInstance().logAction(name + " Fan " + action);
    }
}
