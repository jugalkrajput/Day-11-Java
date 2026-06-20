package com.example;

class Box<T> {
    private T content;
    
    // Getter
    public T get() {
        return content;
    }
    
 // Setter
    public void set(T content) {
        this.content = content;
    }
}

public class GenericsClassDemo {
    public static void main(String[] args) {
        // Box for String
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics!");
        System.out.println(stringBox.get());  // Hello Generics!
        
        // Box for Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());  // 100
    }
}

