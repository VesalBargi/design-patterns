public interface TaskState {
    void markAsComplete(Task task);

    void deleteForever(Task task);
}
