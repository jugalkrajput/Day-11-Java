package com.example;

// T only accepts Number or its subclasses (Integer, Double, Float, etc.)
class Calculator<T extends Number> {
    private T num;
    
    Calculator(T num) {
        this.num = num;
    }
    
    public double doubleValue() {
        return num.doubleValue();  // Number class ka method
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> c1 = new Calculator<>(10);
        Calculator<Double> c2 = new Calculator<>(5.5);
        // Calculator<String> c3 = new Calculator<>("Hi"); // ❌ ERROR! String doesn't extend Number
    }
}