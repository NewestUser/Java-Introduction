package lecture7.homework.bank;

public class Account {

    /**
     * Константа за тип на акаунта "ДЕБИТ"
     */
    public static String DEBIT = "DEBIT";

    /**
     * Константа за тип на акаунта "КРЕДИТ"
     */
    public static String CREDIT = "CREDIT";

    private final String currency;
    private final String type;

    private double amount;

    /**
     * Конструкорът на класът {@link Account}.
     *
     * @param currency валутата на акаунта.
     * @param type     типът на акаунта.
     * @param amount   първоначалния баланс на акаунта.
     */
    public Account(String currency, String type, double amount) {
        this.currency = currency;
        this.type = type;
        this.amount = amount;
    }

    /**
     * Метод, който проверява дали валутата на акаунта е същата, като тази подадена на метода.
     *
     * @param currency валутата, срещу която ще се проверява.
     * @return true ако е в същата валута, false в противен случай.
     */
    public boolean isInCurrency(String currency) {
        return this.currency.equalsIgnoreCase(currency);
    }

    /**
     * Метод връщаш текущия баланс на акаунта.
     *
     * @return баланс на акаунта.
     */
    public double getBalance() {
        return amount;
    }

    /**
     * Проверява дали валутата на каунта и типът на акаунта са същите, като тези подадени на метода.
     *
     * @param accountCurrency валутата срещу, която ще се проверява.
     * @param accountType     типът на акаунта срещу, който ще се проверява.
     * @return true ако са еднакви, false в противен случай.
     */
    public boolean hasCurrencyAndType(String accountCurrency, String accountType) {

        return this.currency.equalsIgnoreCase(accountCurrency)
                && this.type.equalsIgnoreCase(accountType);
    }

    @Override
    public String toString() {
        return String.format("Account { %s %.2f %s }", currency, amount, type);
    }
}
