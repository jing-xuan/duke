public class Command {
    public void execute(TaskList tasks, Storage storage) {
        //do nothing
        System.out.println("Default command");
    }

    public boolean isExit() {
        return false;
    }
}
