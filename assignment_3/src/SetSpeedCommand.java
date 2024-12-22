public class SetSpeedCommand implements Command {
    private final Fan fan;
    private final String speed;

    public SetSpeedCommand(Fan fan, String speed) {
        this.fan = fan;
        this.speed = speed;
    }

    @Override
    public void execute() {
        fan.setSpeed(speed);
    }
}
