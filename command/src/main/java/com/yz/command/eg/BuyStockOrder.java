package com.yz.command.eg;

/**
 * ConcreteCommand Class.
 */
public class BuyStockOrder implements Order {
    private Stock stock;

    public BuyStockOrder(Stock st) {
        stock = st;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
