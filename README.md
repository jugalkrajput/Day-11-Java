🚀 Day 11 – Generics (<T>, Wildcards)
=========================================

Aaj ka topic Generics hai – iska matlab hai Type Safety (compile-time error catch karna). Agar aapne C++ mein Templates padhe hain, toh Generics unka Java version hai.

Generics ka biggest faida: Aapko ClassCastException runtime pe nahi milega, kyunki error compile time pe hi pakad liya jaata hai.

🔹 1. Why Generics? (Without vs With)
=======================================

Without Generics (Old style – Type unsafe):
-------------------------------------------
Example
---------

List list = new ArrayList();  // Raw type

list.add("Rahul");

list.add(10);                 // Integer allowed (but type mismatch)

String name = (String) list.get(0);  // Works

String wrong = (String) list.get(1); // Runtime Error: ClassCastException ❌

With Generics (Type safe):
--------------------------

Example
--------

List<String> list = new ArrayList<>();  // Generic type

list.add("Rahul");

// list.add(10);  // Compile-time Error! ❌ (Cannot add Integer to List<String>)

String name = list.get(0);  // No casting needed

🔹 2. Generic Class (Box<T>)
=============================

Hum apni khud ki generic class bana sakte hain. T type parameter hai (Type variable). Aap T ki jagah koi bhi class use kar sakte hain.

Example
--------

// Generic class definition

class Box<T> {
    private T content;
    
    // Setter
    public void set(T content) {
        this.content = content;
    }
    
    // Getter
    public T get() {
        return content;
    }
}

public class Main {
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

Note: Aap T ki jagah E (Element), K (Key), V (Value) bhi use kar sakte hain – convention hai.

🔹 3. Generic Methods
=======================

Method ko bhi generic bana sakte hain – even agar class generic nahi hai.

java
public class GenericMethodDemo {
    // Generic method to print any type of array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4};
        String[] strArr = {"A", "B", "C"};
        
        printArray(intArr);  // 1 2 3 4 
        printArray(strArr);  // A B C 
    }
}
Key point: <T> return type se pehle likha jaata hai – isse compiler ko pata chalta hai ki yeh generic method hai.

🔹 4. Bounded Type Parameters (<T extends Number>)
====================================================

Agar aap chahte hain ki T sirf specific types (jaise Number aur uske subclasses) ko hi accept kare – toh extends use karein.

Example
--------

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
🔹 5. Wildcards (?)
====================

Wildcard ? unknown type ko represent karta hai. Iska use generic methods mein flexibility dene ke liye hota hai.

1. Unbounded Wildcard (?):
   -----------------------

java
public static void printList(List<?> list) {   // Accepts List of ANY type
    for (Object obj : list) {
        System.out.print(obj + " ");
    }
}

2. Upper Bounded Wildcard (? extends T):
   -------------------------------------

Example
--------

// Accepts List of Number OR any subclass (Integer, Double, Float)

public static double sum(List<? extends Number> list) {

    double total = 0;

    for (Number n : list) {

        total += n.doubleValue();

    }

    return total;

}


3. Lower Bounded Wildcard (? super T):
=======================================

Example
-------

// Accepts List of Integer OR any superclass (Number, Object)

public static void addIntegers(List<? super Integer> list) {

    list.add(10);

    list.add(20);

}
