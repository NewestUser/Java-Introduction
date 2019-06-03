package lecture10.homework.shop;

/**
 * Този клас моделира цена на даден продукт. Той е използван като super клас на промоционалните цени.
 * Основното нещо, което има в този клас е сумата пари която трябва да се заплати.
 */
public class Price {

    public final double price;

    public Price(double price) {
        this.price = price;
    }

    /**
     * Този метод проверява дали сумата, която е предоставена от клиента е достатъчна за да се закупи желаното
     * от него количество.
     *
     * @param amount   сумата пари на клиента.
     * @param quantity количеството което клиента иска да закупи.
     * @return true ако сумата е достатъчна, false в противен случай.
     */
    public boolean canBePaid(int amount, int quantity) {

        return calculateForQuantity(quantity) <= amount;
    }

    /**
     * Този метод изчислява каква сума пари трябва да се плати за да бъде закупен този продукт.
     *
     * @param quantity количеството, което се закупува.
     * @return сумата пари, необходима за закупуването.
     */
    public double calculateForQuantity(int quantity) {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("(%.2f)", price);
    }

    /**
     * Този метод е презаписан, за да може да се сравняват различните цени.
     *
     * @param other другата цена с която да се сравни.
     * @return true ако цените са еднакви, false в противен случай.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Price price1 = (Price) other;

        return Double.compare(price1.price, price) == 0;
    }
}
