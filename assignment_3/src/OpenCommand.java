public class OpenCommand implements Command {
    private final Curtain curtain;

    public OpenCommand(Curtain curtain) {
        this.curtain = curtain;
    }

    @Override
    public void execute() {
        curtain.open();
    }
}
