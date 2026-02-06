import java.util.*;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static HashMap<String, Employee> map = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        employees = EmployeeFileHandler.load();
        for(Employee e: employees) map.put(e.getId(), e);

        int choice;
        do {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1.Add Employee");
            System.out.println("2.View Employees");
            System.out.println("3.Search Employee");
            System.out.println("4.Update Employee");
            System.out.println("5.Delete Employee");
            System.out.println("6.Reports");
            System.out.println("7.Save");
            System.out.println("8.Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: addEmployee(); break;
                case 2: display(); break;
                case 3: search(); break;
                case 4: update(); break;
                case 5: delete(); break;
                case 6: reports(); break;
                case 7: EmployeeFileHandler.save(employees); break;
                case 8: System.out.println("Exiting..."); break;
            }
        } while(choice!=8);
    }

    static void addEmployee(){
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        if(map.containsKey(id)){
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Dept: ");
        String dept = sc.nextLine();
        System.out.print("Position: ");
        String pos = sc.nextLine();
        System.out.print("Salary: ");
        double sal = sc.nextDouble(); sc.nextLine();

        Employee e = new Employee(id,name,dept,pos,sal);
        employees.add(e);
        map.put(id,e);
        System.out.println("✅ Added successfully");
    }

    static void display(){
        if(employees.isEmpty()){
            System.out.println("No employees");
            return;
        }
        for(Employee e: employees) System.out.println(e);
    }

    static void search(){
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        Employee e = map.get(id);
        if(e!=null) System.out.println(e);
        else System.out.println("Not found");
    }

    static void update(){
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine();
        Employee e = map.get(id);
        if(e==null){ System.out.println("Not found"); return;}

        System.out.print("New name: ");
        e.setName(sc.nextLine());
        System.out.print("New dept: ");
        e.setDepartment(sc.nextLine());
        System.out.print("New position: ");
        e.setPosition(sc.nextLine());
        System.out.print("New salary: ");
        e.setSalary(sc.nextDouble()); sc.nextLine();

        System.out.println("Updated successfully");
    }

    static void delete(){
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();
        Employee e = map.remove(id);
        if(e!=null){
            employees.remove(e);
            System.out.println("Deleted");
        } else System.out.println("Not found");
    }

    static void reports(){
        EmployeeReportGenerator.salaryReport(employees);
        EmployeeReportGenerator.departmentReport(employees);
    }
}

