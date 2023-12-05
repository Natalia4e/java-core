package Homework4;

public class Main {
    public static void main(String[] args) {
        try {
            Account account = new Account(1000); // Создаем счет с начальным балансом 1000
            account.deposit(500); // Вносим депозит 500
            account.withdraw(2000); // Пытаемся снять 2000
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}