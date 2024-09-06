package com.java.concurrency;

import java.io.Serializable;

class SerializeExample implements Serializable {
    //protected synchronized String name = "CONSTANT";
    // Serializable: Objects implementing this interface are serialized automatically.
    // The serialization process is handled by the JVM.

    protected String names = "Constant";
}
public class SerializationProgram {

    public static void main(String[] args){

    }
}
