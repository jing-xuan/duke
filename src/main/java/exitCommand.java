public class exitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Storage storage) {
        //do nothing
        //storage.save(tasks);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
