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
        return "[" + this.getStatusIcon() + "]" + this.description;
    }

    public static int getNumTasks() {
        return numTasks;
    }

    public static void incrementTasks() {
        numTasks++;
    }
}
