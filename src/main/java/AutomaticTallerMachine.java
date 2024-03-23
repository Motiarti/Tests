import java.util.List;
import java.util.Scanner;

public class AutomaticTallerMachine {
    Scanner scanner = new Scanner(System.in);
    private int operation;
    private double withdrawSum;
    private double depositSum;
    private final int currentAccountId;
    List<Account> accountList;
    Account currentAccount;

    public AutomaticTallerMachine(int currentAccountId, List<Account> accountList) {
        this.currentAccountId = currentAccountId;
        this.accountList = accountList;
        this.currentAccount = accountList.get(currentAccountId);
    }

    public void displayMainMenu() {
        System.out.println("�������� ����");
        System.out.println("1: ��������� ������ �����");
        System.out.println("2: ����� �� �����");
        System.out.println("3: �������� �� ����");
        System.out.println("4: �����");
        selectOperation();
        operations(operation);
    }

    private void selectOperation() {
        System.out.print("������� ����� ����: ");
        operation = scanner.nextInt();
        if (operation < 1 || operation > 4) {
            System.out.println();
            System.out.println("�������� �������� \n");
            displayMainMenu();
        }
    }

    public void operations(int operation) {
        Account currentAccount = accountList.get(currentAccountId);
        switch (operation) {
            case 1 -> {
                System.out.println();
                System.out.println("������ ����� " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case 2 -> {
                System.out.println();
                System.out.print("������� ����� ��� ������ �� �����: ");
                withdrawSum = getWithdrawSum();
                currentAccount.withdraw(withdrawSum);
                System.out.println("������ ����� ����� ������ ������� �����: " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case 3 -> {
                System.out.println();
                System.out.print("������� ����� ��� �������� �� ����: ");
                depositSum = getDepositSum();
                currentAccount.deposit(depositSum);
                System.out.println("������ ����� ����� �������� ������� �����: " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case 4 -> {
                System.out.println();
                System.out.println("�� ����� �� ����. ������� ����� ����� ��� ������� 99 ��� ���������� ������������ \n");
                Account.getAccountId();
            }
        }
    }

    private double getWithdrawSum() {
        withdrawSum = scanner.nextDouble();
        while (true) {
            if (withdrawSum > 0 && withdrawSum < currentAccount.getBalance()) {
                break;
            }
            else if (withdrawSum < 0) {
                System.out.println("������� �� ���������� �����. ������� ����� �����: ");
                withdrawSum = scanner.nextDouble();
            }
            else if (withdrawSum > currentAccount.getBalance()) {
                System.out.println("������� ����� ������ ������� �����. ������� ����� ������ �������: ");
                withdrawSum = scanner.nextDouble();
            }
        }
        return withdrawSum;
    }

    private double getDepositSum() {
        depositSum = scanner.nextDouble();
        while (true) {
            if (depositSum > 0) {
                break;
            }
            else if (depositSum < 0) {
                System.out.println("������� �� ���������� �����. ������� ����� �����: ");
                depositSum = scanner.nextDouble();
            }
        }
        return depositSum;
    }
}
