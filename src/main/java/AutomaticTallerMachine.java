import java.util.Scanner;

public class AutomaticTallerMachine {
    private final Account currentAccount;
    private int operation;
    private double withdrawSum;
    private double depositSum;
    Scanner scanner = new Scanner(System.in);

    public AutomaticTallerMachine(Account currentAccount) {
        this.currentAccount = currentAccount;
    }


    public void displayMainMenu() {
        System.out.println("�������� ����");
        System.out.println("0: ��������� ������ �����");
        System.out.println("1: ����� �� �����");
        System.out.println("2: �������� �� ����");
        System.out.println("3: �����");
        selectOperation();
        doOperation(operation);
    }

    private void selectOperation() {
        System.out.print("������� ����� ����: ");
        operation = scanner.nextInt();
        while (operation < 0 || operation >= MenuOptions.values().length) {
            System.out.println();
            System.out.println("�������� ��������");
            System.out.print("������� ����� ����: ");
            operation = scanner.nextInt();
        }
    }

    public void doOperation(int operation) {
        MenuPoints menuPoints = MenuPoints.values()[operation];
        switch (menuPoints) {
            case BALANCE -> {
                System.out.println();
                System.out.println("������ ����� " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case WITHDRAW -> {
                System.out.println();
                System.out.print("������� ����� ��� ������ �� �����: ");
                withdrawSum = getWithdrawSum();
                currentAccount.withdraw(withdrawSum);
                System.out.println("������ ����� ����� ������ ������� �����: " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case DEPOSIT -> {
                System.out.println();
                System.out.print("������� ����� ��� �������� �� ����: ");
                depositSum = getDepositSum();
                currentAccount.deposit(depositSum);
                System.out.println("������ ����� ����� �������� ������� �����: " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case EXIT -> {
                System.out.println();
                System.out.println("������������ ���������");
            }
        }
    }

    private double getWithdrawSum() {
        withdrawSum = scanner.nextDouble();
        while (withdrawSum < 0) {
            System.out.println("������� ������������ �����");
            withdrawSum = scanner.nextDouble();
            if (withdrawSum > currentAccount.getBalance()) {
                System.out.println("������� ����� ������ ������� �����. ������� ����� ������ �������: ");
                withdrawSum = scanner.nextDouble();
            }
        }
        return withdrawSum;
    }

    private double getDepositSum() {
        depositSum = scanner.nextDouble();
        while (depositSum < 0) {
            System.out.println("������� �� ���������� �����. ������� ����� �����: ");
            depositSum = scanner.nextDouble();
        }
        return depositSum;
    }
}
