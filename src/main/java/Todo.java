public class Todo extends Task {
    public Todo(String description){
        super(description);
        System.out.println("Added new task: " + "[T]" + super.toString());
    }

    @Override
    public  String toString() {
        return "[T]" + super.toString();
    }
}
