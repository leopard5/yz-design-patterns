package com.yz.command.eg;

public class SellStockOrder implements Order {
    private StockTrade stock;

    public SellStockOrder(StockTrade st) {
        stock = st;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
