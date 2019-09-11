import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DukeTest {
    @Test
    public void EventTest() {
        TaskList tester = new TaskList();
        assertEquals(0, tester.getNumTasks());
        Task t = new Todo("test1");
        tester.addTask(t);
        assertEquals(1, tester.getNumTasks());

    }

}
