
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class Duke extends Application {
    public TaskList tasks;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    Stage stage;
    public Duke() {
        this.tasks = new TaskList();
        this.stage = new Stage();

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

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

    public void begin() {
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
        d.begin();
        d.run();
    }
 }
