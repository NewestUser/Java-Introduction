package lecture10.homework.shop;

/**
 * Този клас моделира магазин. Един магазин може да бъде зареждан с продукти на определан цена и сопределно количество
 * и също така да продава вече заредени продукти.
 */
public class Shop {

    /**
     * В този масив пазим всички вече заредени продукти.
     */
    private final ProductStorage[] inventory = new ProductStorage[1000];

    /**
     * С този метод можем да зареждам продукт с определено име, фиксирана цена и количество
     *
     * @param name     името на продукта.
     * @param price    цената на продукта.
     * @param quantity количеството на продукта.
     * @return true ако успешно е зареден продукта, false в противен случай.
     */
    public boolean add(String name, double price, int quantity) {

        return add(name, new Price(price), quantity);
    }

    /**
     * С този метод, аналогично на първия може да се зарежда даден продукт, с тази разлика че
     * е възможно да бъде използван за зареждане на продукти на промоционални цени.
     *
     * @param name     име на продукта.
     * @param price    цена на продукта.
     * @param quantity количество на продукта.
     * @return true ако успешно е зареден продукта, false в противен случай.
     */
    public boolean add(String name, Price price, int quantity) {

        for (int i = 0; i < inventory.length; i++) {

            ProductStorage currentStorage = inventory[i];

            if (currentStorage == null) {
                ProductStorage item = new ProductStorage(name, price, quantity);
                inventory[i] = item;

                return true;
            } else if (currentStorage.tryToIncreaseQuantity(name, price, quantity)) {

                return true;
            }
        }

        return false;
    }

    /**
     * С този метод може да бъде закупуван/продаван даден продукт.
     *
     * @param productQuery името на продукта, който клиента иска да закупи.
     * @param amount       цената на продукта.
     * @param quantity     количеството от продукта.
     * @return при успешно закупуване се връща {@link PurchaseReceipt} в противен случай null.
     */
    public PurchaseReceipt buy(String productQuery, int amount, int quantity) {

        for (int i = 0; i < inventory.length; i++) {
            ProductStorage item = inventory[i];

            if (item == null) {
                continue;
            }

            PurchaseReceipt recipe = item.tryToSell(productQuery, amount, quantity);

            if (item.isDepleted()) {
                inventory[i] = null; // избягваме Memory Leak
            }

            if (recipe != null) {

                return recipe;
            }
        }

        return null;
    }

    /**
     * Този метод, аналогично на предходния може да се закупува продукт с тази разлика че количеството винаги е 1.
     *
     * @param productQuery името на продукта, който клиента иска да закупи.
     * @param amount       сумата пари, която клиента има налична.
     * @@return при успешно закупуване се връща {@link PurchaseReceipt} в противен случай null.
     */
    public PurchaseReceipt buy(String productQuery, int amount) {

        return buy(productQuery, amount, 1);
    }

}
