import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected Date byDate;

    /**
     * Creates a new Deadline object
     *
     * @param description name of the task
     * @param byDate the deadline of the task
     */
    public Deadline(String description, Date byDate){
        super(description);
        this.byDate = byDate;
    }

    /**
     * Creates a description of the task, containing its type, its description, whether it has been done
     * as well as its deadline
     *
     * @return the String that describes the object
     */
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM YYYY");
        simpleDateFormat.format(byDate, stringBuffer, new FieldPosition(0));
        return "[D]" + super.toString() + " (by : " + stringBuffer + ")";
    }
}
