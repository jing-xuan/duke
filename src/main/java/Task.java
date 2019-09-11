import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

enum taskType {
    deadline,
    event,
    todo
}
public class Task {
    protected static int numTasks = 0;
    protected String description;
    protected Boolean isDone;
    public Task(String description){
        this.description = description;
        this.isDone = false;
        numTasks++;
    }

    /**
     * Returns the status icon to be used in the toString functions
     * @return the icon, either a tick or a cross
     */
    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Marks the specified task as done
     */
    public void markAsDone(){
        isDone = true;
    }

    /**
     * Creates the description of a task containing its name and whether it has been done
     * @return the String with all the information about the task
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Returns the number of tasks currently stored in the TaskList object
     * @return the number of tasks currently stored
     */
    public static int getNumTasks() {
        return numTasks;
    }

    public static void incrementTasks() {
        numTasks++;
    }

    /**
     * Converts a string into a Task object, used by the Storage.load() function.
     * Takes in a string read from the output file, and converts it into a Task by
     * decoding its task type, its done state, its date and its description
     *
     * @param s the String to be parsed into a Task
     * @return the Task object derived from parsing the String
     * @throws DukeException Happens when the line cannot be parsed. Output file may have been tampered
     */
    public static Task stringToTask(String s) throws DukeException {
        try {
            s = s.substring(s.indexOf('[') + 1);
            taskType t;
            Date d = new Date();
            String desc = "";
            boolean isDone = false;
            if (s.charAt(0) == 'T') {
                t = taskType.todo;
            } else if (s.charAt(0) == 'E') {
                t = taskType.event;
            } else {
                t = taskType.deadline;
            }
            s = s.substring(s.indexOf('[') + 1);
            if (s.charAt(0) == '\u2713') {
                isDone = true;
            }
            if (t.equals(taskType.todo)) {
                desc = s.substring(s.indexOf("]") + 2);
                Task task = new Todo(desc);
                if (isDone) {
                    task.markAsDone();
                }
                return task;
            }
            String dateString = "";
            String marker;
            if (t.equals(taskType.event)) {
                marker = " (at : ";
            } else {
                marker = " (by : ";
            }
            desc = s.substring(s.indexOf("]") + 2, s.indexOf(marker));
            dateString = s.substring(s.indexOf(marker) + 7, s.indexOf(")"));
            try {
                d = Task.stringToDate(dateString);
            } catch (Exception e){
                e.getMessage();
            }
            if (t.equals(taskType.event)) {
                Task task = new Event(desc, d);
                if (isDone) {
                    task.markAsDone();
                }
                return task;
            } else {
                Task task = new Deadline(desc, d);
                if (isDone) {
                    task.markAsDone();
                }
                return task;
            }
        } catch (Exception e){
            System.out.println("Error parsing saved task");
        }
        return new Todo("");
    }

    private static Date stringToDate(String d) throws DukeException {
        Date date = new Date();
        try{
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
            date = sdfrmt.parse(d);
            return date;
        } catch (ParseException e) {
            throw new DukeException("Invalid Date Format");
        }
    }
}
