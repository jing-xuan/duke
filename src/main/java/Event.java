import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected String at;
    protected Date atDate;
    public Event(String description, Date atDate){
        super(description);
        this.atDate = atDate;
    }

    /**
     * Creates a description of the task, containing its type, its description, whether it has been done
     * as well as its date
     *
     * @return the String that describes the object
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM YYYY");
        simpleDateFormat.format(atDate, stringBuffer, new FieldPosition(0));
        return "[E]" + super.toString() + " (at : " + stringBuffer + ")";
    }
}
