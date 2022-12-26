package ru.gb.excseminar;

// import java.util.ArrayList;
// import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            main.printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
            //List<Integer> list = new ArrayList<>(null);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArithmeticException ex) {
            System.out.println("На ноль делить нельзя!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
