import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected Date byDate;
    public Deadline(String description, Date byDate){
        super(description);
        this.byDate = byDate;
        System.out.println("Added new task: " + this.toString());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, haa");
        simpleDateFormat.format(byDate, stringBuffer, new FieldPosition(0));
        System.out.println(stringBuffer);
        return "[D]" + super.toString() + " (by : " + stringBuffer + ")";
    }
}
