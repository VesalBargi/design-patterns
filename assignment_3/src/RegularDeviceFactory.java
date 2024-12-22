public class RegularDeviceFactory implements DeviceFactory {
    @Override
    public Light createLight(String room) {
        return new Light(room + " (Regular Light)");
    }

    @Override
    public Fan createFan(String room) {
        return new Fan(room + " (Regular Fan)");
    }

    @Override
    public Curtain createCurtain(String room) {
        return new Curtain(room + " (Regular Curtain)");
    }
}
