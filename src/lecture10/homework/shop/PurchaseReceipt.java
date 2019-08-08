package lecture10.homework.shop;

/**
 * Този клас моделира касова бележка. Той съдържа името на продукта, който е закупен,
 * цената на която е закупен, количеството което е закупено, и сумата пари платена от клиента.
 */
public class PurchaseReceipt {

    private final String productName;
    private final Price price;
    private int boughtQuantity;
    private final double paidAmount;

    /**
     * Конструктор на касова бележка.
     *
     * @param productName    името на закупения продукт.
     * @param price          цената на която е закупен продукта.
     * @param boughtQuantity количеството което е закупено.
     * @param paidAmount     платената сума от клиента.
     */
    PurchaseReceipt(String productName, Price price, int boughtQuantity, double paidAmount) {
        this.productName = productName;
        this.price = price;
        this.boughtQuantity = boughtQuantity;
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "PurchaseReceipt{" +
                "productName='" + productName + '\'' +
                ", boughtQuantity=" + boughtQuantity +
                ", price=" + price +
                ", paidAmount=" + paidAmount +
                ", change=" + getChange() +
                '}';
    }

    /**
     * Вътрешен метод, който изчислява рестото на клиента.
     *
     * @return сумата пари, която е върната на клиента.
     */
    private double getChange() {
        return paidAmount - price.calculateForQuantity(boughtQuantity);
    }
}
