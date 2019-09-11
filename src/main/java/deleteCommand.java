public class deleteCommand extends Command {
    private int index;
    public deleteCommand(int i){
        this.index = i;
    }

    /**
     * Removes the specified task from the tasklist.
     * It checks if the task ID exists within the tasklist. If it does,
     * it removes the task, and tells the user how many tasks are remaining
     *
     * @param tasks the TaskList object storing the tasks
     * @param storage the Storage object responsible for storing objects in persistent storage
     */
    public void execute(TaskList tasks, Storage storage) {
        //do nothing
        try {
            if (index < 0) throw new DukeException("Index must be bigger than 0");
            if (index >= tasks.getNumTasks()) throw new DukeException("No such task");
            tasks.deleteTask(index);
            System.out.println("Deleted task. You now have " + tasks.getNumTasks() + " tasks left");
        } catch (Exception e){
            e.getMessage();
        }
    }

    public boolean isExit() {
        return false;
    }
}
