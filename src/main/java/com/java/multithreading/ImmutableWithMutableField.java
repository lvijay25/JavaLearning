package com.java.multithreading;

import java.util.Date;

final class ImmutableFields  {

    private final int id;
    private final Date date;

    public ImmutableFields(int id, Date date) {
        this.id = id;
        this.date = new Date(date.getTime());
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableField [ " + id + " Date " + date + " ]";
    }
}

public class ImmutableWithMutableField {

    public static void main(String[] args) throws InterruptedException {

        ImmutableFields immutable = new ImmutableFields(1, new Date());
        System.out.println(immutable);
        Thread.sleep(3000);
        System.out.println(immutable);
        Thread.sleep(2000);
        ImmutableFields immutable1 = new ImmutableFields(2, new Date());
        System.out.println(immutable1);
        Thread.sleep(1000);
        System.out.println(immutable1);
        Thread.sleep(1000);

    }

}
