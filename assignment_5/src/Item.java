public abstract class Item {
    protected String title;

    public Item(String title) {
        this.title = title;
    }

    public abstract void display(int indent);

    public abstract void markAsComplete();

    public abstract void deleteForever();
}
