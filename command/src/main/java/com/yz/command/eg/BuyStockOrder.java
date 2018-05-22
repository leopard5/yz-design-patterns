package com.yz.command.eg;

/**
 * ConcreteCommand Class.
 */
public class BuyStockOrder implements Order {
    private StockTrade stock;

    public BuyStockOrder(StockTrade st) {
        stock = st;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
