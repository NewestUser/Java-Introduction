package lecture10.homework.shop;

/**
 * Този клас репрезентира зареден продукт (инвентар) в магазина. Като се пази информация за това,
 * какво е името на продукта, на каква цена се продава и какво е наличното количество от този продукт.
 */
class ProductStorage {

    private final String name;
    private final Price price;
    private int quantity;

    /**
     * Конструктор чрез, който можем да създадем инвентар описваш цена и количество на един продукт.
     *
     * @param name     името на продукта, който бива зареден в магазина.
     * @param price    цената на продукта, която ще бъде използвана при продажба.
     * @param quantity количеството от продукта, което е заредено в магазина.
     */
    ProductStorage(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Този метод се опитва да издаде касова бележка, ако параметрите, които са подадени са такива, че да
     * удовлетворяват продажбата на продукта.
     *
     * @param productQuery името на продукта, който клиента иска да закупи.
     * @param amount       сумата която клиента има налична.
     * @param quantity     количеството, което клиента иска да закупи.
     * @return при покриване на критерия за продажба се връща {@link PurchaseRecipe} с детайлите за продажбата,
     * в противен случай се връща null.
     */
    PurchaseRecipe tryToSell(String productQuery, int amount, int quantity) {

        if (canBeBought(productQuery, amount, quantity)) {

            reduceQuantity(quantity);

            return new PurchaseRecipe(productQuery, price, quantity, amount);
        }

        return null;
    }

    /**
     * Този метод се опитва да увечличи количеството от даден продукт.
     * Той се използва, когато магазина иска да зареди наново продукт, който все още не е изчерпан.
     *
     * @param name     името на продукта.
     * @param price    цената на продукта.
     * @param quantity количеството което се зарежда в магазина.
     * @return true при успешно зареждане, false в противен случай.
     */
    boolean tryToIncreaseQuantity(String name, Price price, int quantity) {

        if (isForProduct(name, price)) {
            increaseQuantity(quantity);
            return true;
        }

        return false;
    }

    /**
     * Този метод проверява дали е изчерпано количеството от този продукт.
     *
     * @return true когато е изчерпано, false в противен случай.
     */
    boolean isDepleted() {
        return this.quantity == 0;
    }

    /**
     * Вътрешен метод, който проверява дали клиента иска да закупи продукт с това име, цена и количество.
     *
     * @param productQuery името на продукта, който клиента търси.
     * @param amount       сумата пари, която клиента има налична.
     * @param quantity     количеството, което иска да закпуи.
     * @return true при успешно закупуване, false в противен случай.
     */
    private boolean canBeBought(String productQuery, int amount, int quantity) {

        return name.equals(productQuery)
                && this.price.canBePaid(amount, quantity);
    }

    /**
     * Вътрешен метод, който проверява дали името и цената са еднакви с тази на вече заредения продукт.
     *
     * @param name  име на продукт, който ще бъде зареждан.
     * @param price цената на продукта, която ще бъде зареждана.
     * @return true при еднакво име и цена, false в противен случай.
     */
    private boolean isForProduct(String name, Price price) {
        return this.name.equals(name)
                && this.price.equals(price);
    }

    /**
     * Този метод намалява количеството на заредения продукт.
     *
     * @param quantity количеството с което да се намали.
     */
    private void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Този метод увеличава количеството на заредения продукт.
     *
     * @param quantity количеството с което да се увеличи.
     */
    private void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
