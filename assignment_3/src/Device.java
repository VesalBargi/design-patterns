public abstract class Device {
    String name;

    public Device(String name) {
        this.name = name;
    }

    abstract void performAction(String action);
}
