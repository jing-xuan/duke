import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?\n");
        int numTasks = 0;
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
                        System.out.println((i + 1) + ". [" + arrTask[i].getStatusIcon() + "] " + arrTask[i].description);
                    }
                } else {
                    arrTask[numTasks] = new Task(userInput);
                    numTasks++;
                    System.out.println("Added new task: " + userInput);
                }
            }
        }
    }
}
