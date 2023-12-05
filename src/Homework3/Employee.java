package Homework3;


// Абстрактный базовый класс
abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    // Абстрактный метод для расчета среднемесячной заработной платы
    public abstract double calculateMonthlySalary();
}
