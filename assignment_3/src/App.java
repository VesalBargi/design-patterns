public class App {
    public static void main(String[] args) throws Exception {
        DeviceFactory smartFactory = new SmartDeviceFactory();
        DeviceFactory regularFactory = new RegularDeviceFactory();

        Light livingRoomLight = smartFactory.createLight("Living Room");
        Light bedroomLight = regularFactory.createLight("Bedroom");
        Curtain kitchenCurtain = smartFactory.createCurtain("Kitchen");
        Curtain livingRoomCurtain = regularFactory.createCurtain("Living Room");

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand("TurnOnLivingRoomLight", new TurnOnCommand(livingRoomLight));
        remoteControl.setCommand("TurnOffBedroomLight", new TurnOffCommand(bedroomLight));
        remoteControl.setCommand("OpenKitchenCurtain", new OpenCommand(kitchenCurtain));
        remoteControl.setCommand("CloseLivingRoomCurtain", new CloseCommand(livingRoomCurtain));

        MacroCommand nightMode = new MacroCommand();
        nightMode.addCommand(new TurnOffCommand(livingRoomLight));
        nightMode.addCommand(new TurnOffCommand(bedroomLight));
        nightMode.addCommand(new CloseCommand(kitchenCurtain));
        nightMode.addCommand(new CloseCommand(livingRoomCurtain));

        remoteControl.setCommand("NightMode", nightMode);

        remoteControl.executeCommand("TurnOnLivingRoomLight");
        remoteControl.executeCommand("OpenKitchenCurtain");
        remoteControl.executeCommand("NightMode");
    }
}
