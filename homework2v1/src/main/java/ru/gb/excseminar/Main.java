package ru.gb.excseminar;

//import java.util.ArrayList;
//import java.util.List;

public class Main {
    public static void main( String[] args ) {
        try {
            int d = 0;
            int [] intArray = {1, 2, 3, 4};
            //List<Integer> list = new ArrayList<>(null);
            double catchedRes1 = intArray[5] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | NullPointerException | IndexOutOfBoundsException ex) {
            System.out.println("Catching exception: " + ex);
        } catch (Throwable ex) {
            System.out.println("Catching exception: " + ex);
        } 
    }
}
