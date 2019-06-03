package lecture10.homework.shop;

/**
 * Този клас моделира цена от тип 2 за 1, като той наследява базовия клас {@link Price}.
 */
public class TwoForOnePrice extends Price {

    public TwoForOnePrice(double price) {
        super(price); // извикваме super конструктора на Price, за да подадем цената
    }

    /**
     * Този метод презаписва функционалността от Price, тъй като логиката за продажба
     * на продукт в промоция е по различна.
     *
     * @param amount   сумата пари на клиента.
     * @param quantity количеството което клиента иска да закупи.
     * @return true ако сумата е достатъчна, false в противен случай.
     */
    @Override
    public boolean canBePaid(int amount, int quantity) {

        if (quantity < 2 || quantity % 2 != 0) {
            return false;
        }

        return calculateForQuantity(quantity) <= amount;
    }

    /**
     * Този метод презаписва функционалността от Price, тъй като логиката за изчисляване
     * на това каква сума пари трябва да се плати за да бъде закупен този продукт е по разлина.
     *
     * @param quantity количеството, което се закупува.
     * @return сумата пари, необходима за закупуването.
     */
    @Override
    public double calculateForQuantity(int quantity) {
        int taxQuantity = quantity / 2;

        return price * taxQuantity;
    }

    @Override
    public String toString() {

        return String.format("(2 за 1 при цена %.2f)", price);
    }
}
