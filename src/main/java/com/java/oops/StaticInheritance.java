package com.java.oops;

import static com.java.oops.StaticClass.sum;

class StaticClass {
    public static int sum(int x){
        return x * 10;
    }

    public int summing(int x){
        return x * 10;
    }
}

class ChildStaticClass extends StaticClass {
    public static int sum(int x){
        return x * 15;
    }

    @Override
    public int summing(int x) {
        return super.summing(x);
    }
}
class GrandChildClass extends ChildStaticClass{
    public static int sum(int x){
        return x * 20;
    }
    @Override
    public int summing(int x){
        return super.summing(x);
    }
}
public class StaticInheritance {
    public static void main(String[] args) {
        System.out.println(ChildStaticClass.sum(10));

        GrandChildClass grandChildClass = new GrandChildClass();

        int result = grandChildClass.summing(10);

        System.out.println(result);

        switch(result)
        {
            case 101:
                System.out.println("Case0 " + result);
            case 100:
                System.out.println("Case1 " + result);
                break;
            case 200:
                System.out.println("Case2 " + result);
                break;
            case 300:
                System.out.println("Case3 " + result);
                break;
            case 400:
                System.out.println("Case4 " + result);
                break;
            default:
                System.out.println("Default " + result);
        }

    }
}
