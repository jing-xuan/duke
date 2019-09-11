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

    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone(){
        isDone = true;
    }
    
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public static int getNumTasks() {
        return numTasks;
    }

    public static void incrementTasks() {
        numTasks++;
    }

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
