import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static String[] userTasks = new String[100];
    private static boolean[] taskDone = new boolean[100];
    private static int numTasks = 0;
    public static void main(String[] args) {
        Arrays.fill(taskDone, false);
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?\n");
        String userInput;
        do {
            userInput = input.nextLine();
            if (!userInput.equals("list") && !userInput.equals("bye") && !userInput.startsWith("done ")){
                addTask(userInput);
            } else if (userInput.equals("list")){
                printTasks();
            } else if (userInput.startsWith("done ")){
                doneTask(userInput);
            }
        } while(!userInput.equals("bye"));
        System.out.println("Bye, hope to see you again!");
    }

    public static void addTask(String task){
        userTasks[numTasks] = task;
        System.out.println("added: " + task);
        numTasks++;
    }

    public static void printTasks(){
        if (numTasks == 0){
            System.out.println("You have no tasks!");
            return;
        }
        for (int i = 0; i < numTasks; i++){
            String symbol = (taskDone[i] ? "\u2713" : "\u2718");
            System.out.println((i + 1) + ". [" + symbol + "] " + userTasks[i]);
        }
    }

    public static void doneTask(String userInput) {
        int i = (userInput.charAt(userInput.length() - 1)) - '0' - 1;
        if (i < 0 || i > 99 || i > numTasks - 1) {
            System.out.println("That is not a valid task ID");
            return;
        }
        taskDone[i] = true;
        System.out.println("Have marked this task as done:\n [\u2713] " + userTasks[i]);
    }
}
