import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static int numTasks = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?\n");
        Task[] arrTask = new Task[100];
        while (true){
            String userInput;
            userInput = input.nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. hope to see you again!");
                break;
            } else {
                if (userInput.startsWith("done")){
                    int i = userInput.charAt((userInput.length()) - 1) - '0';
                    if (i > 0 && i <= numTasks) {
                        arrTask[i - 1].markAsDone();
                        System.out.println("Marked as done:\n[" + arrTask[i - 1].getStatusIcon() + "] " + arrTask[i - 1].description);
                    } else {
                        System.out.println("No such task");
                    }
                } else if (userInput.startsWith("list")){
                    for (int i = 0; i < numTasks; i++){
                        System.out.println((i + 1) + ". " + arrTask[i].toString());
                    }
                } else {
                    if (userInput.startsWith("deadline")){
                        userInput = userInput.replaceAll("deadline ", "");
                        String[] split = userInput.split("/by ");
                        arrTask[numTasks] = new Deadline(split[0], split[1]);
                    } else if (userInput.startsWith("todo ")){
                        userInput = userInput.replaceAll("todo ", "");
                        arrTask[numTasks] = new Todo(userInput);
                    } else if (userInput.startsWith("event")){
                        userInput.replaceAll("event ", "");
                        String[] split = userInput.split("/at ");
                        arrTask[numTasks] = new Event(split[0], split[1]);
                    }
                    System.out.println("Added new task: " + arrTask[numTasks].toString());
                    numTasks++;
                    System.out.println("You now have " + numTasks + " tasks");
                }
            }
        }
    }
}
