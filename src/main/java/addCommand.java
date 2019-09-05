public class addCommand extends Command {
    protected Task t;

    public addCommand(Task t){
        this.t = t;
    }

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
