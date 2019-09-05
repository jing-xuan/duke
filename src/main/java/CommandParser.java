import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandParser {
    public static Command parse(String s) throws DukeException {
        if (s.equals("bye")){
            //return bye command
            return new exitCommand();
        }
        if (s.equals("list")){
            return new listCommand();
        }
        if (s.startsWith("save")){
            return new saveCommand();
        }
        if (s.startsWith("delete")) {
            int index;
            s = s.substring(7);
            if (s.equals("")){
                throw new DukeException("Specify the index of task to be deleted");
            }
            index = Integer.parseInt(s) - 1;
            return new deleteCommand(index);
        }
        if (s.startsWith("done")){
            int index;
            s = s.substring(5);
            if (s.equals("")){
                throw new DukeException("Specify the index of task to be marked as done");
            }
            index = Integer.parseInt(s) - 1;
            return new doneCommand(index);
        if (s.startsWith("find")){
            String desc = s.substring(5);
            return new findCommand(desc);
        }
        if (s.startsWith("deadline")) {
            try {
                if (!s.contains(" /by: ")) {
                    throw new DukeException("No /by: command");
                }
                String name = s.substring(9, s.indexOf(" /by: "));
                if (name.length() == 0) throw new DukeException("Task must have a name");
                String d = s.substring(s.indexOf("/by: ") + 5);
                if (d.equals("")) throw new DukeException("Deadline task must have a date");
                Date date = parseDate(d);
                Task t = new Deadline(name, date);
                return new addCommand(taskType.deadline, t);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (s.startsWith("todo")) {
            //add task command
            try {
                String name = s.substring(5);
                if (name.length() == 0) throw new DukeException("Task must have a name");
                Task t = new Todo(name);
                Command c = new addCommand(taskType.todo, t);
                return c;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (s.startsWith("event")) {
            //add event command
            try {
                if (!s.contains(" /at: ")) {
                    throw new DukeException("No /at: command");
                }
                String name = s.substring(6, s.indexOf(" /at: "));
                if (name.length() == 0) throw new DukeException("Task must have a name");
                String d = s.substring(s.indexOf("/at: ") + 5);
                if (d.equals("")) throw new DukeException("Event task must have a date");
                Date date = parseDate(d);
                System.out.println(date);
                Task t = new Event(name, date);
                return new addCommand(taskType.event, t);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        throw new DukeException("Sorry, I don't understand your command");
    }

    private static Date parseDate(String d) throws DukeException {
        Date date = new Date();
        try{
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            date = sdfrmt.parse(d);
            return date;
        } catch (ParseException e) {
            throw new DukeException("Invalid Date Format");
        }
    }

}
