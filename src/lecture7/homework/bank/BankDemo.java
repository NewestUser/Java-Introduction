package lecture7.homework.bank;

public class BankDemo {

    public static void main(String[] args) {

        // създай клиенти
        Customer john = new Customer("John", "Doe", 20);
        Customer foo = new Customer("Foo", "Doe", 30);
        Customer bar = new Customer("Bar", "Doe", 40);

        // създай банка с капацитет от 100 акаунта
        Bank bank = new Bank(100);

        // отвори 2 акаунта в различни валути на първия клиент
        bank.addAccount(john, 10, "EUR", Account.CREDIT);
        bank.addAccount(john, 55, "BGN", Account.CREDIT);

        // отвори 2 други акаунта на другите клиенти
        bank.addAccount(foo, 20, "EUR", Account.CREDIT);
        bank.addAccount(bar, 40, "GBP", Account.DEBIT);

        // принтирай общия брой пари в банката според валутата
        System.out.printf("Банката има EUR %.2f\n", bank.getTotalMoney("EUR"));
        System.out.printf("Банката има GBP %.2f\n", bank.getTotalMoney("GBP"));
        System.out.printf("Банката има BGN %.2f\n\n", bank.getTotalMoney("BGN"));
        System.out.printf("Банката има INR %.2f\n\n", bank.getTotalMoney("INR"));

        // принтирай акаунтите на първия клиент
        System.out.printf("Клиент %s има следните акаунти:\n", john.getFullName());
        john.printAccountDetails();

        // премахни един от акаунтите на първия клиент
        bank.removeAccount(john, "EUR", Account.CREDIT);

        // принтирай акаунтите на първия клиент
        System.out.printf("\nКлиент %s има следните акаунти:\n", john.getFullName());
        john.printAccountDetails();
    }
}
