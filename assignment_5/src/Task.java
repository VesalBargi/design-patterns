public class Task extends Item {
    private String description;
    private String dueDate;
    private String priority;
    private TaskState state;
    private boolean isDeleted = false;

    public Task(String title, String description, String dueDate, String priority) {
        super(title);
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.state = new IncompleteState();
    }

    public boolean isComplete() {
        return state instanceof CompleteState;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    @Override
    public void display(int indent) {
        if (isDeleted)
            return;
        System.out.println(" ".repeat(indent) + "- Task: " + title + " (Priority: " + priority + ")");
    }

    @Override
    public void markAsComplete() {
        state.markAsComplete(this);
    }

    @Override
    public void deleteForever() {
        state.deleteForever(this);
    }
}
