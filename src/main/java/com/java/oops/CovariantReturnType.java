package com.java.oops;

class ParentClass{
    int i;
    int getMultipleNumber(int x){
        System.out.println("Parent Class");
        this.i = x;
        return i * 10;
    }

    ParentClass getMultipleNumber(int x, int y){
        System.out.println("ChildClass Covariant Return Type..");
        this.i = x * y;
        return this;
    }
}
class ChildClass extends ParentClass {
    @Override
    // double getMultipleNumber(int x) *** Warning attempting to use incompatible return type
    int getMultipleNumber(int x){
        System.out.println("Child Class");
        this.i = x;
        return i * 50;
    }

    ChildClass getMultipleNumber(int x, int y){
        System.out.println("ChildClass Covariant Return Type..");
        this.i = x * y;
        return this;
    }
}

public class CovariantReturnType {
    public static void main(String[] args){
        ParentClass parentClass = new ParentClass();
        int num = parentClass.getMultipleNumber(10);
        System.out.println("Multiplied Number " + num);

        parentClass = new ChildClass();
        int num1 = parentClass.getMultipleNumber(10);
        System.out.println("Multiplied Number " + num1);

        ParentClass parentClass1 = new ParentClass();
        System.out.println("ParentCLass Return Value " + parentClass1.getMultipleNumber(10, 10).i);

        parentClass1 = new ChildClass();
        System.out.println("ChildCLass Return Value " + parentClass1.getMultipleNumber(10, 10).i);

    }
}
