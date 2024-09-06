package com.java.multithreading;

class Threading extends Thread {
    String names;
    String address;
    String currentAddress;
    public Threading(Runnable target, String names, String address, String currentAddress) {
        super(target);
        this.names = names;
        this.address = address;
        this.currentAddress = currentAddress;
    }
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCurrentAddress() {
        return currentAddress;
    }
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }
}
public class MultiThreading {
    public static void main(String[] args){
        Threading thread = new Threading(new Runnable() {
            @Override
            public void run() {

            }
        }, "Vijay", "16-575", "Chittoor");
        thread.start();
        thread.setPriority(10);
        System.out.println(thread.getAddress() + " " + thread.getCurrentAddress());
        System.out.println(thread.getNames() + " " + thread.getAddress() + " " + thread.getCurrentAddress() + " Thread Priority " + thread.getPriority());
    }
}
