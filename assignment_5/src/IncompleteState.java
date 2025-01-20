public class IncompleteState implements TaskState {
    @Override
    public void markAsComplete(Task task) {
        task.setState(new CompleteState());
        System.out.println("Task marked as complete.");
    }

    @Override
    public void deleteForever(Task task) {
        System.out.println("Cannot delete an incomplete task directly.");
    }
}
