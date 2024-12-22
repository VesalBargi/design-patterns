public class CloseCommand implements Command {
    private final Curtain curtain;

    public CloseCommand(Curtain curtain) {
        this.curtain = curtain;
    }

    @Override
    public void execute() {
        curtain.close();
    }
}
