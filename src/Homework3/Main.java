package Homework3;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Freelancer("Maria", 500));   // Почасовая ставка 500
        employees.add(new Freelancer("Andrei", 800));     // Почасовая ставка 800
        employees.add(new Worker("Petr", 50000));   // Фиксированная месячная оплата 50000
        employees.add(new Worker("Denis", 350000));     // Фиксированная месячная оплата 350000
        employees.add(new Freelancer("Ella", 200));    // Почасовая ставка 200

        // Вывод информации о среднемесячной зарплате каждого сотрудника
        for (Employee employee : employees) {
            System.out.println(employee.name + ": " + employee.calculateMonthlySalary());
        }
    }
}