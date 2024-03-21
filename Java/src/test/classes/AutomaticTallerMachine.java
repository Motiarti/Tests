package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomaticTallerMachine {
    Scanner sc = new Scanner(System.in);
    int operation;
    double withdrawSum;
    double depositSum;

    public void operations(List<Account> acc, int operation) {
        Account currentAccountId = acc.get(App.currentAccountId);
        switch (operation) {
            case 1 -> {
                System.out.println("Баланс равен " + currentAccountId.getBalance());
                displayMainMenu();
            }
            case 2 -> {
                withdrawSum = getWithdrawSum();
                currentAccountId.withdraw(withdrawSum);
                System.out.println("Баланс счета после снятия средств равен: " + currentAccountId.getBalance());
                displayMainMenu();
            }
            case 3 -> {
                depositSum = getDepositSum();
                currentAccountId.deposit(depositSum);
                System.out.println("Баланс счета после внесения средств равен: " + currentAccountId.getBalance());
                displayMainMenu();
            }
            case 4 -> App.getAccountId();
        }
    }

    public void displayMainMenu() {
        List<Account> accounts = generateAccounts();
        System.out.println("Основное меню");
        System.out.println("1: проверить баланс счета");
        System.out.println("2: снять со счета");
        System.out.println("3: положить на счет");
        System.out.println("4: выйти");
        selectOperation(accounts);
        operations(accounts, operation);
    }

    private void selectOperation(List<Account> accounts) {
        System.out.print("Введите пункт меню: ");
        operation = sc.nextInt();
        if (operation < 1 || operation > 4) {
            System.out.println("Неверная операция");
            displayMainMenu();
        }
    }

    private double getWithdrawSum() {
        System.out.print("Введите сумму для снятия со счета: ");
        return withdrawSum = sc.nextDouble();
    }

    private double getDepositSum() {
        System.out.print("Введите сумму для взноса на счет: ");
        return depositSum = sc.nextDouble();
    }

    public void completeService() {
        System.out.println("Обслуживание завершено");
        sc.close();
    }

    public void completeDescription() {
        System.out.println("Для завершения обслуживания введите 99");
    }

    private static List<Account> generateAccounts() {
        double initialBalance = 10000.0;
        int numberOfAccounts = 10;
        List<Account> output = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            output.add(new Account(i, initialBalance));
        }
        return output;
    }
}
