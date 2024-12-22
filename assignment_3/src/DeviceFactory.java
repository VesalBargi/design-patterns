public interface DeviceFactory {
    Light createLight(String room);

    Fan createFan(String room);

    Curtain createCurtain(String room);
}
