enum taskType {
    deadline,
    event,
    todo
}

public class addCommand extends Command {
    protected taskType type;
    protected Task t;

    public addCommand(taskType type, Task t){
        this.type = type;
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
