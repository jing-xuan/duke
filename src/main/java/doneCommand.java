public class doneCommand extends Command {
    private int index;
    public doneCommand(int i){
        this.index = i;
    }

    /**
     * Marks a task as done.
     * First checks if the specified task ID exists within the tasklist.
     * If yes, the task is marked as done.
     *
     * @param tasks The tasklist object that contains all the tasks
     * @param storage The storage object responsible for storing tasks in persistent storage
     */
    public void execute(TaskList tasks, Storage storage) {
        //do nothing
        try {
            if (index < 0) throw new DukeException("Index must be bigger than 0");
            if (index >= tasks.getNumTasks()) throw new DukeException("No such task");
            tasks.get(index).markAsDone();
            System.out.println("Marked task as done!" + tasks.get(index).toString());
        } catch (Exception e){
            e.getMessage();
        }
    }

    public boolean isExit() {
        return false;
    }
}
