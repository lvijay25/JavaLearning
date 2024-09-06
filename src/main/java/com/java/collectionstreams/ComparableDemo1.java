package com.java.collectionstreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Player implements Comparable<Player> {

    private int ranking;

    private String name;

    private int age;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return String.valueOf(age);
    }

    @Override
    public int compareTo(Player o){
        return Integer.compare(this.age, o.age);
    }
}
public class ComparableDemo1 {

    public static void main(String[] args){

        List<Player> sortByRank = new ArrayList<>();

        Player player = new Player(1, "John", 55);
        Player player1 = new Player(1, "Nolan Chinn", 30);
        Player player2 = new Player(1, "Susan Swanson", 28);

        sortByRank.add(player);
        sortByRank.add(player1);
        sortByRank.add(player2);

        Collections.sort(sortByRank);

        System.out.println(sortByRank);
    }

}
