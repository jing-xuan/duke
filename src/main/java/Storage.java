import java.io.*;

public class Storage {
    protected String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public void load(TaskList tasks) {
        try{
            System.out.println("Loading your previous tasks");
            FileReader fileReader = new FileReader(this.filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                Task t = Task.stringToTask(line);
                tasks.addTask(t);
            }
            bufferedReader.close();
            tasks.listTasks();
        } catch (FileNotFoundException e) {
            System.out.println("Specified file not found! Task list will be regenerated");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DukeException e) {
            e.getMessage();
        }
    }

    public void save(TaskList tasks) {
        try{
            FileWriter fileWriter = new FileWriter(this.filepath);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            for (int i = 0; i < tasks.getNumTasks(); i++){
                bufferedWriter.write(((i + 1) + ". " + tasks.get(i).toString()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Specified file not found! Task list will be regenerated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
