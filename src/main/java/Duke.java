
import java.util.Scanner;
import java.io.IOException;

public class Duke {
    public TaskList tasks;

    public Duke() {
        this.tasks = new TaskList();
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        CommandParser Parser = new CommandParser();
        Storage storage = new Storage("output.txt");
        storage.load(tasks);
        boolean exit = false;
        while (!exit) {
            try {
                String s = input.nextLine();
                Command c = CommandParser.parse(s);
                c.execute(tasks, storage);
                exit = c.isExit();
            } catch (DukeException e){
                System.out.println(e.getMessage());
            }
        }
        this.end();
    }

    public void end() {
        System.out.println("Bye, hope to see you again");
        //do the other stuff to end
    }

    public void start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?\n");
    }

    public static void main(String[] args) throws IOException {
        Duke d = new Duke();
        d.start();
        d.run();
    }
}
