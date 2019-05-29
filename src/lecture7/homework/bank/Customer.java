package lecture7.homework.bank;

public class Customer {

    private final String fistName;
    private final String lastName;
    private final int age;

    /**
     * Масив с акаунти, които клиента може да има.
     */
    private Account[] accounts = new Account[10];

    public Customer(String fistName, String lastName, int age) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Добави акаунт към клиента.
     *
     * @param account акаунта, който да бъде добавен.
     * @return true, при успешно добавяне, false в противен случай.
     */
    public boolean addAccount(Account account) {

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }

        return false;
    }

    /**
     * Премахва акаунта от клиента.
     *
     * @param accountCurrency валутата на акаунта.
     * @param accountType     типът на акаунта.
     * @return true при успешно премахнат акаунт, false в противен случай.
     */
    public boolean removeAccount(String accountCurrency, String accountType) {

        for (int i = 0; i < accounts.length; i++) {

            Account account = accounts[i];

            if (account.hasCurrencyAndType(accountCurrency, accountType)) {
                accounts[i] = null;
                return true;
            }
        }

        return false;
    }

    public String getFullName() {
        return fistName + " " + lastName;
    }

    /**
     * Принтирай всички отворени акаунти на клиента.
     */
    public void printAccountDetails() {
        for (Account account : accounts) {
            if (account != null) {
                System.out.println(account);
            }
        }
    }

    public int getAge() {
        return age;
    }
}
