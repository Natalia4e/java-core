package Homework3;

class Freelancer extends Employee {
    private double hourlyRate;

    public Freelancer(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateMonthlySalary() {
        // Расчет среднемесячной заработной платы для фрилансера
        return 20.8 * 8 * hourlyRate;
    }
}
