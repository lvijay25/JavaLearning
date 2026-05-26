package com.java.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureMethod {

    public static CompletableFuture<Integer> getStockPrice(String ticker, int numberOfShares) {
        return CompletableFuture.supplyAsync(() -> {
            int price = 1000;
            if (ticker.equals("GOOGLE"))
                price = 500;
            return numberOfShares * price;
        });
    }

    public static void main(String[] args) {

        List<String> symbols = List.of("GOOGLE", "AMAZON");
        CompletableFuture.supplyAsync(() -> symbols.get(1))
                .thenCompose(symbol -> getStockPrice(symbol, 2))
                .thenAccept(value -> System.out.println("Stock price: " + value));
    }
}
