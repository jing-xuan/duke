import java.text.FieldPosition;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Duke {
    protected static ArrayList<Task> arrTask = new ArrayList<Task>();
    public static void main(String[] args) throws IOException {
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
                if (userInput.startsWith("done")) {
                    int i = userInput.charAt((userInput.length()) - 1) - '0';
                    if (i > 0 && i <= arrTask.size()) {
                        arrTask.get(i - 1).markAsDone();
                        System.out.println("Marked as done:\n" + arrTask.get(i - 1).toString());
                    } else {
                        System.out.println("No such task");
                    }
                } else if (userInput.startsWith("list")) {
                    if (arrTask.size() == 0) {
                        System.out.println("You have no tasks to list!");
                    } else {
                        for (int i = 0; i < arrTask.size(); i++) {
                            System.out.println((i + 1) + ". " + arrTask.get(i).toString());
                        }
                    }
                } else if (userInput.startsWith("delete")){
                    int i = userInput.charAt((userInput.length()) - 1) - '0';
                    if (i > 0 && i <= arrTask.size()) {
                        System.out.println("Noted, this task has been removed:\n" + arrTask.get(i - 1).toString());
                        arrTask.remove(i - 1);
                        System.out.println("Now you have " + arrTask.size() + " tasks");
                    } else {
                        System.out.println("No such task");
                    }
                } else if (userInput.startsWith("save")) {
                    FileWriter writer = new FileWriter("output.txt");
                    Date date = new Date();
                    writer.write("List as of " + date.toString() + "\n");
                    for (int i = 0; i < arrTask.size(); i++){
                        writer.write((i + 1) + ". "+ arrTask.get(i).toString() + "\n");
                    }
                    writer.close();
                    System.out.println("Saved list to output.txt!");
                }
                else if (userInput.startsWith("deadline") || userInput.startsWith("todo") || userInput.startsWith("event")){
                    if (userInput.startsWith("deadline")) {
                        userInput = userInput.replaceAll("deadline", "");
                        String[] split = userInput.split("/by ");
                        if (split.length == 1) {
                            System.out.println("Incomplete Task Entry!");
                        } else {
                            boolean format = true;
                            Date javaDate = new Date();
                            try{
                                SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy kkss");
                                javaDate = sdfrmt.parse(split[1]);
                            } catch (ParseException e){
                                format = false;
                                System.out.println("Invalid date format!");
                            }
                            if (format){
                                Task newTask = new Deadline(split[0], javaDate);
                                arrTask.add(newTask);
                            }
                        }
                    } else if (userInput.startsWith("todo")){
                        userInput = userInput.replaceAll("todo", "");
                        if (userInput.equals("")) {
                            System.out.println("Incomplete Task Entry!");
                        } else {
                            Task newTask = new Todo(userInput);
                            arrTask.add(newTask);
                        }
                    } else if (userInput.startsWith("event")){
                        userInput.replaceAll("event", "");
                        String[] split = userInput.split("/at ");
                        if (split.length == 1) {
                            System.out.println("Incomplete Task Entry!");
                        } else {
                            boolean format = true;
                            Date javaDate = new Date();
                            try{
                                SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy kkss");
                                javaDate = sdfrmt.parse(split[1]);
                            } catch (ParseException e){
                                format = false;
                                System.out.println("Invalid date format!");
                            }
                            if (format){
                                Task newTask = new Event(split[0], javaDate);
                                arrTask.add(newTask);
                            }
                        }
                    }
                } else {
                    System.out.println("Sorry, that is not a valid command");
                }
            }
        }
    }
}
