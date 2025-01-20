public class CompleteState implements TaskState {
    @Override
    public void markAsComplete(Task task) {
        System.out.println("Task is already complete.");
    }

    @Override
    public void deleteForever(Task task) {
        System.out.println("Task deleted forever.");
        task.setDeleted(true);
    }
}
