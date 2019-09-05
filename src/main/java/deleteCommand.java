public class deleteCommand extends Command {
    private int index;
    public deleteCommand(int i){
        this.index = i;
    }
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
