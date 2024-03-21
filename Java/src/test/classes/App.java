package classes;

import java.util.Scanner;

public class App {
    public static int currentAccountId;
    static Scanner sc = new Scanner(System.in);
    static AutomaticTallerMachine atm = new AutomaticTallerMachine();

    public static void main(String[] args) {
        getAccountId();

    }

    public static void getAccountId() {
        System.out.print("¬ведите номер счета: ");
        currentAccountId = sc.nextInt();
        while (true) {
            if (currentAccountId == 99) {
                atm.completeService();
                break;
            } else if (!(currentAccountId >= 0 && currentAccountId < 10)) {
                atm.completeDescription();
                System.out.print("¬ведите номер счета: ");
                currentAccountId = sc.nextInt();
            } else {
                atm.displayMainMenu();
                sc.close();
                break;
            }
        }
    }
}
