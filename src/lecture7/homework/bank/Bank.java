package lecture7.homework.bank;

public class Bank {

    /**
     * Минималната сума, необходима за създаване на акаунт.
     */
    private static final int MIN_AMOUNT = 5;

    /**
     * Всички валути, които банката поддържа.
     */
    private static String[] SUPPORTED_CURRENCIES = {"EUR", "GBP", "BGN", "CAD"};

    /**
     * Списъкът с акаунти, които банката е отворила.
     */
    private Account[] accounts;

    /**
     * Конструкторът на класът {@link Bank}.
     *
     * @param capacity броят акаунти, които ще може да поддържа тази банка.
     */
    public Bank(int capacity) {
        accounts = new Account[capacity];
    }

    /**
     * Този метод цели да отвори нов акаунт на клиента.
     * За целта се проверяват входните параметри за акаунта дали са валидни.
     * При успешна валидация се създава нов акаунт, който бива записан в банката и в клиента.
     *
     * @param customer      клиента, на който да ще бъде отворен новия акаунт.
     * @param initialAmount първоначалната вноска на акаунта.
     * @param currency      валутата на акаунта.
     * @param accountType   типът на акаунта.
     * @return true при успешно създаден акаунт, false в противен случай.
     */
    public boolean addAccount(Customer customer, double initialAmount, String currency, String accountType) {

        if (initialAmount < MIN_AMOUNT) { // провери за минимална вноска
            return false;
        }

        if (customer.getAge() < 18){
            return false;
        }

        boolean currencyIsSupported = false; // провери дали валутата е поддържана от банката
        for (String supportedCurrency : SUPPORTED_CURRENCIES) {

            if (supportedCurrency.equalsIgnoreCase(currency)) {
                currencyIsSupported = true; // успешно установхиме че валутата е поддържана от банката
                break; // прекрати цикъла, няма смисъл да обикаляме повече валути
            }
        }

        if (!currencyIsSupported) {
            return false;
        }

        // провери дали типът на акаунта е валиден
        if (!Account.CREDIT.equalsIgnoreCase(accountType) && !Account.DEBIT.equalsIgnoreCase(accountType)) {
            return false;
        }

        Account newCustomerAccount = new Account(currency.toUpperCase(), accountType.toUpperCase(), initialAmount);

        // добави акаунта в клиента
        customer.addAccount(newCustomerAccount);

        // добави акаунта в банката
        addAccountToBank(newCustomerAccount);

        return true;
    }

    /**
     * Вътрешен метод, който е видим само за банката. Този метод добавя вече създадения акаунт
     * в масива с акаунти на банката.
     *
     * @param account акаунта, който трябва да бъде записан.
     * @return true при успешно записване, false в противен случай.
     */
    private boolean addAccountToBank(Account account) {

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }

        return false;
    }

    /**
     * Връща общия брой пари от всички създадени акаунти с определена валута.
     *
     * @param currency валутата за която да бъдат изчислени сумата пари.
     * @return общия брой пари в дадената валута.
     */
    public double getTotalMoney(String currency) {
        int total = 0;

        for (Account account : accounts) { // обиколи всички акаунти
            if (account == null) {
                continue; // от тях вземи само тези, които са отворени
            }

            if (account.isInCurrency(currency)) {
                total += account.getBalance();
            }
        }

        return total;
    }

    /**
     * Метод, който премахва вече отворен акаунт от банката и от клиента.
     *
     * @param customer        клиента, на който да бъде премахнат акаунта.
     * @param accountCurrency валутата на акаунта, който да бъде затворен.
     * @param accountType     типът на акаунта, който да бъде затворен.
     * @return true при успешно премахване на акаунт с определена валута и тип, false в противен случай.
     */
    public boolean removeAccount(Customer customer, String accountCurrency, String accountType) {

        // премахни акаунта от клиента
        boolean accountIsRemoved = customer.removeAccount(accountCurrency, accountType);

        if (!accountIsRemoved) {
            return false;
        }

        // обиколи всички акаунти в банката
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];

            if (account.hasCurrencyAndType(accountCurrency, accountType)) {
                accounts[i] = null; // премахни акаунта от банката

                return true;
            }
        }

        return false;
    }
}
