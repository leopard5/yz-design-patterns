package com.yz.command.eg;

/**
 * Command Pattern
 */
public class CommandPatternApp {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStockOrder buyStockOrder = new BuyStockOrder(abcStock);
        SellStockOrder sellStockOrder = new SellStockOrder(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
