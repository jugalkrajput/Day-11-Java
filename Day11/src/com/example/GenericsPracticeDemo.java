package com.example;

import java.util.Arrays;

// Generic class
class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
}

public class GenericsPracticeDemo {
    
    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        // 1. Test Box class
        Box<String> box = new Box<>();
        box.set("Java Generics");
        System.out.println("Box contains: " + box.get());
        
        // 2. Test swap method with Integer array
        Integer[] intArr = {10, 20, 30, 40};
        System.out.println("Before swap: " + Arrays.toString(intArr));
        swap(intArr, 0, 3);
        System.out.println("After swap: " + Arrays.toString(intArr));  // [40, 20, 30, 10]
        
        // 3. Test swap method with String array
        String[] strArr = {"A", "B", "C", "D"};
        System.out.println("Before swap: " + Arrays.toString(strArr));
        swap(strArr, 1, 2);
        System.out.println("After swap: " + Arrays.toString(strArr));  // [A, C, B, D]
    }
}
