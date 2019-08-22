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
        String userInput;
        String[] userTasks = new String[100];
        int numTasks = 0;
        do {
            userInput = input.nextLine();
            if (!userInput.equals("list") && !userInput.equals("bye")){
                userTasks[numTasks] = userInput;
                System.out.println("added: " + userInput);
                numTasks++;
            } else {
                for (int i = 0; i < numTasks; i++){
                    System.out.println((i + 1) + ". " + userTasks[i]);
                }
            }
        } while(!userInput.equals("bye"));
        System.out.println("Bye, hope to see you again!");
    }
}
