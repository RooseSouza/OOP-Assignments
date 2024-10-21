import java.util.Arrays;
import java.util.List;

// Generic class to hold an item
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// Utility class with a generic method
class Utility {
    public static <T> void printArray(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (T element : array) {
            System.out.println(element);
        }
    }
}

// Division class with exception handling
class Division {
    public static double divide(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) numerator / denominator;
    }
}

// Functional interface for math operations
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class assignment7 {
    public static void main(String[] args) {
        // Using the generic class
        try {
            Box<String> stringBox = new Box<>();
            stringBox.setItem("Hello, Generics!");
            System.out.println(stringBox.getItem());
        } catch (Exception e) {
            System.out.println("Error in Box: " + e.getMessage());
        }

        // Using the generic method
        try {
            Integer[] intArray = {1, 2, 3, 4, 5};
            Utility.printArray(intArray);
            
            // Testing with a null array
            Utility.printArray(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error in printArray: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }

        // Exception handling in division
        try {
            System.out.println("Division Result: " + Division.divide(10, 2));
            System.out.println("Division Result: " + Division.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error in Division: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error in Division: " + e.getMessage());
        }

        // Using lambda expressions for math operations
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        };

        // Test the operations
        System.out.println("Addition: " + add.operate(10, 5));
        System.out.println("Subtraction: " + subtract.operate(10, 5));
        System.out.println("Multiplication: " + multiply.operate(10, 5));

        // Handle division and exceptions
        try {
            System.out.println("Division: " + divide.operate(10, 2));
            System.out.println("Division: " + divide.operate(10, 0)); // This will throw an exception
        } catch (ArithmeticException e) {
            System.out.println("Error in Lambda Division: " + e.getMessage());
        }

        // Using lambda with collections
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        System.out.println("Names starting with 'A':");
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(name -> System.out.println("Filtered name: " + name));
    }
}
