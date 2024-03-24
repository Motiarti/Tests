import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Host {
    static List<Account> generateAccounts() {
        double initialBalance = 10000.0;
        int numberOfAccounts = 10;
        List<Account> output = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            output.add(new Account(i, initialBalance));
        }
        return output;
    }

    public static int getAccountId() {
        int currentAccountId;
        Scanner sc = new Scanner(System.in);
        System.out.print("������� ����� �����: ");
        currentAccountId = sc.nextInt();
        while (true) {
            if (currentAccountId == 99) {
                System.out.println("������������ ���������");
                System.exit(0);
            }
            if (!(currentAccountId >= 0 && currentAccountId < 10)) {
                System.out.println("�� ������ ����� �����");
                System.out.println("��� ���������� ������������ ������� 99");
                System.out.print("������� ����� �����: ");
                currentAccountId = sc.nextInt();
            } else {
                break;
            }
        }
        return currentAccountId;
    }
}
