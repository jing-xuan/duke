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

    /**
     * Lists all the tasks currently inside the object, and also notifies the user if there
     * are no tasks to be listed.
     */
    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        if (tasks.size() == 0){
            System.out.println("You have no tasks!");
        }
    }

    /**
     * Goes through all the tasks inside the TaskList object to determine if any of them match the keyword,
     * and print out the matching tasks, if any.
     * @param keyword the keyword to search for
     */
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
