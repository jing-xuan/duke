import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    protected static Task[] arrTask = new Task[100];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?\n");
        while (true){
            String userInput;
            userInput = input.nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. hope to see you again!");
                break;
            } else {
                if (userInput.startsWith("done")){
                    int i = userInput.charAt((userInput.length()) - 1) - '0';
                    if (i > 0 && i <= Task.getNumTasks()) {
                        arrTask[i - 1].markAsDone();
                        System.out.println("Marked as done:\n" + arrTask[i - 1].toString());
                    } else {
                        System.out.println("No such task");
                    }
                } else if (userInput.startsWith("list")){
                    if (Task.getNumTasks() == 0){
                        System.out.println("You have no tasks to list!");
                    } else {
                        for (int i = 0; i < Task.getNumTasks(); i++) {
                            System.out.println((i + 1) + ". " + arrTask[i].toString());
                        }
                    }
                } else if (userInput.startsWith("deadline") || userInput.startsWith("todo") || userInput.startsWith("event")){
                    if (userInput.startsWith("deadline")) {
                        userInput = userInput.replaceAll("deadline", "");
                        String[] split = userInput.split("/by ");
                        if (split.length == 1) {
                            System.out.println("Incomplete Task Entry!");
                        } else {
                            arrTask[Task.getNumTasks()] = new Deadline(split[0], split[1]);
                        }
                    } else if (userInput.startsWith("todo")){
                        userInput = userInput.replaceAll("todo", "");
                        if (userInput.equals("")) {
                            System.out.println("Incomplete Task Entry!");
                        } else {
                            arrTask[Task.getNumTasks()] = new Todo(userInput);
                        }
                    } else if (userInput.startsWith("event")){
                        userInput.replaceAll("event", "");
                        String[] split = userInput.split("/at ");
                        if (split.length == 1) {
                            System.out.println("Incomplete Task Entry!");
                        } else {
                            arrTask[Task.getNumTasks()] = new Event(split[0], split[1]);
                        }
                    }
                } else {
                    System.out.println("Sorry, that is not a valid command");
                }
            }
        }
    }
}
