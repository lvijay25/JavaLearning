package com.java.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureReadString {

    public static String fetch(String path) throws IOException {
        try {
            // Read the string from the path and count....
            return Files.readAllLines(Paths.get(path)).toString();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static CompletableFuture<String> fetchAsync(String path) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return fetch(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static Void handleException(Throwable throwable) {
        System.out.println("ERROR: " + throwable);
        return null;
    }

    public static void main(String... args) {

        String filePath = "C:\\Users\\Prakash\\Downloads\\strings.txt\\";

        // fetch String length
        fetchAsync(filePath)
                .thenApply(String::length)
                .thenAccept(System.out::println)
                .exceptionally(CompletableFutureReadString::handleException)
                .join();

        // fetch String from file.
        fetchAsync(filePath)
                .thenApply(String::toString)
                .thenAccept(System.out::println)
                .exceptionally(CompletableFutureReadString::handleException)
                .join();
        // 81
        // [Hello Concurrency World in Java!!, I Love Concurrency MultiThreading in Java!!!]
    }
}
