package com.yz.command.eg;

public class SellStockOrder implements Order {
    private Stock stock;

    public SellStockOrder(Stock st) {
        stock = st;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
