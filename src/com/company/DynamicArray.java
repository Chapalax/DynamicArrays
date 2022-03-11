package com.company;

public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;
    private int last;

    public DynamicArray(){
        array = new int[10];
        size = 5;
        capacity = 10;
        last = -1;
    }

    public void addToEnd(int value){
        if(last < capacity - 1){
            array[last + 1] = value;
            last++;
            if(last == size){
                size++;
            }
        }
        else{
            int[] swap = new int[array.length * 3 / 2];
            System.arraycopy(array, 0, swap, 0, array.length);
            array = new int[array.length * 3 / 2];
            System.arraycopy(swap, 0, array, 0, array.length);
            array[last + 1] = value;
            last++;
            size = last + 1;
            capacity = array.length;
        }
    }

    public void removeFromEnd(){
        if(last != -1){
            array[last] = 0;
            last--;
        }
        else{
            System.out.println("Error! Array is empty!");
        }
    }

    public void reserve(int n){
        if(n > capacity) {
            capacity = n;
            int[] swap = new int[array.length];
            System.arraycopy(array, 0, swap, 0, array.length);
            array = new int[n];
            System.arraycopy(swap, 0, array, 0, swap.length);
        }
        else if(n >= size){
            capacity = n;
            int[] swap = new int[n];
            System.arraycopy(array, 0, swap, 0, n);
            array = new int[n];
            System.arraycopy(swap, 0, array, 0, n);
        }
        else{
            if(n != capacity) {
                System.out.println("Error! Capacity can't be less than size of array!");
            }
        }
    }

    public void resize(int n){
        if(n < size){
            for(int i = n - 1; i < size; i++){
                array[i] = 0;
            }
            size = n;
        }
        else if(n > capacity){
            int[] swap = new int[n * 3 / 2];
            System.arraycopy(array, 0, swap, 0, array.length);
            array = new int[n * 3 / 2];
            System.arraycopy(swap, 0, array, 0, array.length);
            size = n;
            capacity = array.length;
        }
        else{
            size = n;
        }
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            array[i] = 0;
        }
        last = -1;
    }

    public void get(int index){
        if(index > last) System.out.println("Error! No such index exists");
        else System.out.println(array[index]);
    }

    public void remove(int index){
        if(index > last) System.out.println("Error! No such index exists");
        else {
            array[index] = 0;
            if(index == last){
                last--;
            }
        }
    }

    public void add(int value, int index){
        if(index > capacity){
            int[] swap = new int[index * 3 / 2];
            System.arraycopy(array, 0, swap, 0, array.length);
            array = new int[index * 3 / 2];
            System.arraycopy(swap, 0, array, 0, array.length);
            array[index] = value;
            size = index + 1;
            last = index;
            capacity = array.length;
        }
        else if(index >= size){
            array[index] = value;
            last = index;
            size = index + 1;
        }
        else{
            array[index] = value;
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}