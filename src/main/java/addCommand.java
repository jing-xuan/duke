public class addCommand extends Command {
    protected Task t;

    /**
     * Creates an add command that will add a Task t when executed
     * @param t the task to be added
     */
    public addCommand(Task t){
        this.t = t;
    }

    /**
     * Executes the add command by first checking the description to see if it is a valid task
     * If it is, it will add the task to the tasklist, then print out the task that has been added,
     * as well as the number of tasks in total.
     *
     * @param tasks The TaskList object that stores all the tasks
     * @param storage The Storage object responsible for saving tasks
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        if (t.description.equals("")){
            return;
        }
        try{
            tasks.addTask(t);
            System.out.println("Added new task: " + t.toString());
            System.out.println("You now have " + tasks.getNumTasks() + " tasks");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
