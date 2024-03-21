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
                System.out.println("������ ����� " + currentAccountId.getBalance());
                displayMainMenu();
            }
            case 2 -> {
                withdrawSum = getWithdrawSum();
                currentAccountId.withdraw(withdrawSum);
                System.out.println("������ ����� ����� ������ ������� �����: " + currentAccountId.getBalance());
                displayMainMenu();
            }
            case 3 -> {
                depositSum = getDepositSum();
                currentAccountId.deposit(depositSum);
                System.out.println("������ ����� ����� �������� ������� �����: " + currentAccountId.getBalance());
                displayMainMenu();
            }
            case 4 -> App.getAccountId();
        }
    }

    public void displayMainMenu() {
        List<Account> accounts = generateAccounts();
        System.out.println("�������� ����");
        System.out.println("1: ��������� ������ �����");
        System.out.println("2: ����� �� �����");
        System.out.println("3: �������� �� ����");
        System.out.println("4: �����");
        selectOperation(accounts);
        operations(accounts, operation);
    }

    private void selectOperation(List<Account> accounts) {
        System.out.print("������� ����� ����: ");
        operation = sc.nextInt();
        if (operation < 1 || operation > 4) {
            System.out.println("�������� ��������");
            displayMainMenu();
        }
    }

    private double getWithdrawSum() {
        System.out.print("������� ����� ��� ������ �� �����: ");
        return withdrawSum = sc.nextDouble();
    }

    private double getDepositSum() {
        System.out.print("������� ����� ��� ������ �� ����: ");
        return depositSum = sc.nextDouble();
    }

    public void completeService() {
        System.out.println("������������ ���������");
        sc.close();
    }

    public void completeDescription() {
        System.out.println("��� ���������� ������������ ������� 99");
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
