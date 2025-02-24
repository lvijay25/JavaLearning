package com.java.abstractInterface;

public class NameClass implements MyName<INameApi>{

    public String getMyName(){
        return "String";
    }

    public String getName(){
        return null;
    }
}

