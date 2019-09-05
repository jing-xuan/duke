public class doneCommand extends Command {
    private int index;
    public doneCommand(int i){
        this.index = i;
    }
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
