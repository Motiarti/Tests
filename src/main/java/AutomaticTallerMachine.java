import java.util.List;
import java.util.Scanner;

public class AutomaticTallerMachine {
    private final int currentAccountId;
    private final List<Account> accountList;
    private final Account currentAccount;
    Scanner scanner = new Scanner(System.in);
    private int operation;
    private double withdrawSum;
    private double depositSum;

    public AutomaticTallerMachine(int currentAccountId, List<Account> accountList) {
        this.currentAccountId = currentAccountId;
        this.accountList = accountList;
        this.currentAccount = accountList.get(currentAccountId);
    }

    public void displayMainMenu() {
        System.out.println("Основное меню");
        System.out.println("1: проверить баланс счета");
        System.out.println("2: снять со счета");
        System.out.println("3: положить на счет");
        System.out.println("4: выйти");
        selectOperation();
        operations(operation);
    }

    private void selectOperation() {
        System.out.print("Введите пункт меню: ");
        operation = scanner.nextInt();
        if (operation < 1 || operation > 4) {
            System.out.println();
            System.out.println("Неверная операция \n");
            displayMainMenu();
        }
    }

    public void operations(int operation) {
        Account currentAccount = accountList.get(currentAccountId);
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
                System.out.println("Вы вышли из меню. Введите номер счета или введите 99 для завершения обслуживания \n");
                Host.getAccountId();
            }
        }
    }

    private double getWithdrawSum() {
        withdrawSum = scanner.nextDouble();
        while (withdrawSum < 0) {
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
