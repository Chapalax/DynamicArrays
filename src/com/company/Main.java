package com.company;

public class Main {

    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(5, 15);
        da.print();
        //da.clear();
        //da.print();
        da.addToEnd(666);
        da.print();
        da.get(15);
        da.reserve(70);
        da.add(1, 0);
        da.print();
        da.removeFromEnd();
        da.print();
        da.resize(5);
        da.print();
        da.resize(20);
        da.print();
        da.remove(0);
        da.print();
        da.remove(666);
    }
}
