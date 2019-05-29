# Homework Lecture 7
#java course#

## Strings & Constructors & OOP Exercises


### Task 1

Напишете програма, която симулира работата на банка. 🏦

Програмата трябва да има следните компоненти:
- банка (bank)
- клиент (customer)
- сметка на клиент (account)

Сметката се характеризира с:
- валута (currency) - примерни валути са `BGN`, `GBP`, `EUR`, `CAD`, `USD`, `INR` и тнт...
- баланс (amount) - това е текущия баланс на сметката
- тип на сметката (type) - примерни типове са `CREDIT` и `DEBIT`

Клиентът се характеризира с:
- малко име (first name)
- фамилно име (last name)
- години (age)
- масив от сметки (accounts) - това са всички сметки, които клиента притежава

Банката се характеризира с:
- масив от сметки (accounts) - това са всички сметки, които банката е отворила на клиенти
- масив от валути (supported currencies) - това са всички валути, които банката поддържа 

- способността да отваря смекти на клиенти - клиента отива при банката и заявява валутата (currency), 
първоначалната сума (initial amount) и типът на сметката (type)
    - банката е длъжна да извърши следните проверки преди да създаде сметка
        - първата вноска трябва да е поне 5 пари
        - проверка за валутата дали е поддържана от банката
        - проверка дали клиента е малолетен (ако е под 18г.)
        - проверка дали типът на сметката е `DEBIT` или `CREDIT`
    - ако някоя от проверките не е успешна, няма да бъде създаден сметка
    - ако проверките са успешни ще бъде създадена смекта и тя ще бъде записан в банката и в клиента

- способността да изчислява, колко пари има в банката в определена валута
    - за целта на банката се подава валутата, за която да изчисли общата сума
    - банката трябва да обходи масива със сметки и да намери всички сметки отговарящи на 
    тази валута и да сумира тяхния баланс
    
- способността да закрива смекти - клиентът се връща при банката и заявява валутата на сметката и типът на сметката,
която той иска да бъде затворена
    - банката е длъжна да намери сметката на клиента и да я премахне от клиента
    - банката е длъжна да наери сметката на клиента и да я премахне от своя масив със сметки
    

##### UML Diagram

![bank-uml-diagram](https://i.ibb.co/hZH7rkN/bank-uml-diagram.png)


##### solution

###### Account.java
```java
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
```
    
##### Customer.java
```java
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
```
    
##### Bank.java
```java
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
```
    
##### BankDemo.java
```java
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
```