public class saveCommand extends Command {
    @Override
    public void execute(TaskList tasks, Storage storage){
        System.out.println("Saving your tasks now");
        storage.save(tasks);
    }
}
