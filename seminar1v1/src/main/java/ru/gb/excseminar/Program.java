package ru.gb.excseminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
    // и возвращающий новый массив, каждый элемент которого равен разности элементов 
    // двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо 
    // как-то оповестить пользователя.
    
    public static void main( String[] args ) {

        Program pr = new Program();
        System.out.println(pr.getResult(new ArrayList<Integer>(), Arrays.asList(1, 2, 3)));
    }

    public List<Integer> getResult(List<Integer> list1, List<Integer> list2) {
        if(list1 == null || list2 == null) {
            throw new IllegalStateException("Коллекции не заданы!");
        }
        if(list1.isEmpty() || list2.isEmpty()) {
            throw new IllegalStateException("Не заданы значения массива!");
        }
        if(list1.size() != list2.size()) {
            throw new IllegalStateException("Длины массивов не равны!");
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            resultList.add(list1.get(i) - list2.get(i));
        }
        return resultList;
    }
}
