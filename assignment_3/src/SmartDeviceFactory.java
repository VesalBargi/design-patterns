public class SmartDeviceFactory implements DeviceFactory {
    @Override
    public Light createLight(String room) {
        return new Light(room + " (Smart Light)");
    }

    @Override
    public Fan createFan(String room) {
        return new Fan(room + " (Smart Fan)");
    }

    @Override
    public Curtain createCurtain(String room) {
        return new Curtain(room + " (Smart Curtain)");
    }
}
