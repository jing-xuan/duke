public class findCommand extends Command {
    private String keyword;
    public findCommand(String s){
        this.keyword = s;
    }
    public void execute(TaskList tasks, Storage storage) {
        tasks.findTasks(keyword);
    }

    public boolean isExit() {
        return false;
    }
}
