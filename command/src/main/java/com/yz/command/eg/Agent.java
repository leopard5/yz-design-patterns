package com.yz.command.eg;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker.
 */
public class Agent {
    private List<Order> ordersQueue = new ArrayList();

    public Agent() {
    }

    void placeOrder(Order order) {
        ordersQueue.add(order);
        order.execute();
        ordersQueue.remove(0);
    }

    /**
     * main func
     * @param args
     */
    public static void main(String[] args) {
        StockTrade stock = new StockTrade();
        BuyStockOrder bsc = new BuyStockOrder(stock);
        SellStockOrder ssc = new SellStockOrder(stock);
        Agent agent = new Agent();

        // Buy Shares
        agent.placeOrder(bsc);
        // Sell Shares
        agent.placeOrder(ssc);
    }
}
