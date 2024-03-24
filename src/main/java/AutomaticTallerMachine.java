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
        System.out.println("Основное меню");
        System.out.println("1: проверить баланс счета");
        System.out.println("2: снять со счета");
        System.out.println("3: положить на счет");
        System.out.println("4: выйти");
        selectOperation();
        doOperation(operation);
    }

    private void selectOperation() {
        System.out.print("Введите пункт меню: ");
        operation = scanner.nextInt();
        while (operation < 1 || operation > 4) {
            System.out.println();
            System.out.println("Неверная операция");
            System.out.print("Введите пункт меню: ");
            operation = scanner.nextInt();
        }
    }

    public void doOperation(int operation) {
        switch (operation) {
            case 1 -> {
                System.out.println();
                System.out.println("Баланс равен " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case 2 -> {
                System.out.println();
                System.out.print("Введите сумму для снятия со счета: ");
                withdrawSum = getWithdrawSum();
                currentAccount.withdraw(withdrawSum);
                System.out.println("Баланс счета после снятия средств равен: " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case 3 -> {
                System.out.println();
                System.out.print("Введите сумму для внесения на счет: ");
                depositSum = getDepositSum();
                currentAccount.deposit(depositSum);
                System.out.println("Баланс счета после внесения средств равен: " + currentAccount.getBalance() + "\n");
                displayMainMenu();
            }
            case 4 -> {
                System.out.println();
                System.out.println("Обслуживание завершено");
                System.exit(0);
            }
        }
    }

    private double getWithdrawSum() {
        withdrawSum = scanner.nextDouble();
        while (withdrawSum < 0) {
            System.out.println("Введена некорректная сумма");
            withdrawSum = scanner.nextDouble();
            if (withdrawSum > currentAccount.getBalance()) {
                System.out.println("Введена сумма больше баланса счета. Введите сумму меньше баланса: ");
                withdrawSum = scanner.nextDouble();
            }
        }
        return withdrawSum;
    }

    private double getDepositSum() {
        depositSum = scanner.nextDouble();
        while (depositSum < 0) {
            System.out.println("Введена не корректная сумма. Введите сумму снова: ");
            depositSum = scanner.nextDouble();
        }
        return depositSum;
    }
}
