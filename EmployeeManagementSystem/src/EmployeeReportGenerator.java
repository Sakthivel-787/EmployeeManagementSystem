import java.util.*;

public class EmployeeReportGenerator {

    public static void salaryReport(ArrayList<Employee> employees) {
        if(employees.isEmpty()) {
            System.out.println("No data available");
            return;
        }

        double total = 0;
        double max = employees.get(0).getSalary();
        double min = employees.get(0).getSalary();

        for(Employee e : employees) {
            total += e.getSalary();
            if(e.getSalary() > max) max = e.getSalary();
            if(e.getSalary() < min) min = e.getSalary();
        }

        System.out.println("\n💰 Salary Report");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Salary: ₹" + total);
        System.out.println("Average Salary: ₹" + (total/employees.size()));
        System.out.println("Highest Salary: ₹" + max);
        System.out.println("Lowest Salary: ₹" + min);
    }

    public static void departmentReport(ArrayList<Employee> employees) {
        HashMap<String,Integer> dept = new HashMap<>();

        for(Employee e : employees) {
            dept.put(e.getDepartment(),
                    dept.getOrDefault(e.getDepartment(),0)+1);
        }

        System.out.println("\n🏢 Department Report");
        for(String d : dept.keySet()) {
            System.out.println(d + " : " + dept.get(d) + " employees");
        }
    }
}
