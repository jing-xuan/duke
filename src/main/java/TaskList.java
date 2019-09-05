import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<Task>();

    public int getNumTasks() {
        return tasks.size();
    };
    public void addTask(Task t){
        tasks.add(t);
    }

    public void deleteTask(int i){
        tasks.remove(i);
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        if (tasks.size() == 0){
            System.out.println("You have no tasks!");
        }
    }

    public void findTasks(String keyword) {
        System.out.println("Here are the matching tasks in your list: ");
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).description.contains(keyword)){
                System.out.println((i + 1) + ". " + tasks.get(i).toString());
            }
        }
    }

    public Task get(int i){
        return tasks.get(i);
    }

}
