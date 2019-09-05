public class listCommand extends Command {
    @Override
    public void execute(TaskList tasks, Storage storage) {
        tasks.listTasks();
    }
}
