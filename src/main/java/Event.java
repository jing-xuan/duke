import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected String at;
    protected Date atDate;
    public Event(String description, Date atDate){
        super(description);
        this.atDate = atDate;
        System.out.println("Added new task: " + this.toString());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, haa");
        simpleDateFormat.format(atDate, stringBuffer, new FieldPosition(0));
        return "[E]" + super.toString() + " (at : " + stringBuffer + ")";
    }
}
