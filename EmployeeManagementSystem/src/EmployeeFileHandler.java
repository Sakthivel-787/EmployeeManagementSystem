import java.io.*;
import java.util.ArrayList;

public class EmployeeFileHandler {
    private static final String FILE_NAME = "data/employees.dat";

    public static void save(ArrayList<Employee> employees) {
        try {
            File dir = new File("data");
            if(!dir.exists()) dir.mkdir();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(employees);
            oos.close();
            System.out.println("✅ Data saved to file");
        } catch(IOException e) {
            System.out.println("File Save Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> load() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            list = (ArrayList<Employee>) ois.readObject();
            ois.close();
            System.out.println("📂 Data loaded from file");
        } catch(Exception e) {
            System.out.println("No previous data found.");
        }
        return list;
    }
}
