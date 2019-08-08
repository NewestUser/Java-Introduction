package lecture10.homework;


import lecture10.homework.shop.PurchaseReceipt;
import lecture10.homework.shop.Shop;
import lecture10.homework.shop.TwoForOnePrice;

public class ShopDemo {

    public static void main(String[] args) {

        Shop shop = new Shop();

        shop.add("banana", 20, 2);

        PurchaseReceipt bananaRecipe = shop.buy("banana", 20);

        System.out.println(bananaRecipe);

        shop.add("chocolate", new TwoForOnePrice(10), 2);

        PurchaseReceipt chocolateRecipe = shop.buy("chocolate", 10, 2);

        System.out.println(chocolateRecipe);

        PurchaseReceipt firstBananaPurchase = shop.buy("banana", 20);
        PurchaseReceipt secondBananaPurchase = shop.buy("banana", 25);
        PurchaseReceipt thirdBananaPurchase = shop.buy("banana", 30);
        PurchaseReceipt fourthBananaPurchase = shop.buy("banana", 20);

        PurchaseReceipt firstApplePurchase = shop.buy("apple", 20);
        PurchaseReceipt fifthBananaPurchase = shop.buy("banana", 20);

        System.out.println("\nPurchased ==========\n");
        System.out.println(firstBananaPurchase);
        System.out.println(secondBananaPurchase);
        System.out.println(thirdBananaPurchase);
        System.out.println(fourthBananaPurchase);

        System.out.println("\nNot purchased ==========\n");
        System.out.println(firstApplePurchase);
        System.out.println(fifthBananaPurchase);

        System.out.println("\n==========\n");

        shop.add("carrot", 10, 5);

        PurchaseReceipt firstCarrotPurchase = shop.buy("carrot", 10, 1);
        PurchaseReceipt secondCarrotPurchase = shop.buy("carrot", 10, 4);
        PurchaseReceipt thirdCarrotPurchase = shop.buy("carrot", 40, 4);

        System.out.print("Purchased     ========== ");
        System.out.println(firstCarrotPurchase);
        System.out.print("Not purchased ========== ");
        System.out.println(secondCarrotPurchase);
        System.out.print("Purchased     ========== ");
        System.out.println(thirdCarrotPurchase);

        System.out.println("\n==========\n");

        shop.add("chocolate", new TwoForOnePrice(10), 2);

        PurchaseReceipt firstChocolatePromotion = shop.buy("chocolate", 10, 2);
        PurchaseReceipt secondChocolatePromotion = shop.buy("chocolate", 10, 2);

        System.out.println(firstChocolatePromotion);
        System.out.println(secondChocolatePromotion);

        System.out.println("\n==========\n");

        shop.add("peanuts", new TwoForOnePrice(10), 2);
        shop.add("peanuts", new TwoForOnePrice(10), 2);

        PurchaseReceipt firstPeanutPromotion = shop.buy("peanuts", 10, 2);

        System.out.println(firstPeanutPromotion);
        System.out.println(shop.buy("peanuts", 15, 2));
        System.out.println(shop.buy("peanuts", 5, 1));
    }
}
