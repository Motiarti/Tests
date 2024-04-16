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
        for (MenuOptions option : MenuOptions.values()) {
            System.out.println(option.getOperation());
        }
        doOperation(selectOperation());
    }

    private MenuOptions selectOperation() {
        System.out.print("������� ����� ����: ");
        operation = scanner.nextInt();
        while (operation < 0 || operation > 3) {
            System.out.println();
            System.out.println("�������� ��������");
            System.out.print("������� ����� ����: ");
            operation = scanner.nextInt();
        }
        return MenuOptions.values()[operation];
    }

    public void doOperation(MenuOptions menuOptions) {
        switch (menuOptions) {
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
