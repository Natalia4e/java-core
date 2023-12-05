package Homework3;

class Worker extends Employee {
    private double monthlySalary;

    public Worker(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateMonthlySalary() {
        // Возвращение фиксированной месячной заработной платы
        return monthlySalary;
    }
}