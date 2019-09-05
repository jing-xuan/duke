import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected Date byDate;
    public Deadline(String description, Date byDate){
        super(description);
        this.byDate = byDate;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM YYYY");
        simpleDateFormat.format(byDate, stringBuffer, new FieldPosition(0));
        return "[D]" + super.toString() + " (by : " + stringBuffer + ")";
    }
}
