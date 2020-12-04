package com.lxl.reflect;

public class CreateClassObject {
    public static void main(String[] args) {
        Class<Integer> type = Integer.TYPE;
        System.out.println(type.getName());
        System.out.println(type.getCanonicalName());
    }
}
