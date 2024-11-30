import java.util.*;

class Employee {
    String name;
    int id;
    float salary, bonus, finalsal;
    Employee(String n, int i) {
        name = n;
        id = i;
    }
    void calsalary(int bs, int hra, int allowance) {
        salary = bs + hra + allowance;
    }
    void calbonus() {
        bonus = salary * 0.1f;
        finalsal = salary + bonus;
    }
    void print() {
        System.out.println("The total salary of the employee " + name + " with employee ID " + id + " is: " + finalsal);
    }
}
public class Employee1 {
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = m.nextInt(); 
        m.nextLine();
        Employee[] e = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Details of Employee " + (i + 1) + ": ");
            System.out.print("Enter name: ");
            String name = m.nextLine();
            System.out.print("Enter ID: ");
            int id = m.nextInt();
            m.nextLine();
            e[i] = new Employee(name, id);
        }
        for (int i = 0; i < n; i++) {
            e[i].calsalary(100000, 1000, 20000);
            e[i].calbonus();
            e[i].print();
        }
        m.close();
    }
}
