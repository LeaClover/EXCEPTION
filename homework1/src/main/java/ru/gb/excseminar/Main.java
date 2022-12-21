package ru.gb.excseminar;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    // Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента 
    // целочисленный одномерный массив. Метод должен пройтись по каждому элементу и 
    // проверить что он не равен null. А теперь реализуйте следующую логику:

    // - Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
    // - Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

    public Logger log = Logger.getAnonymousLogger();

    public static void main( String[] args ) {
        Main main = new Main();
        main.log.info("Индексы массива с null элементами: " + main.checkArray(new Integer [] {null, null, 2, 8, 4, null}));
    }

    public List<Integer> checkArray(Integer[] arr) {
        
        if(arr == null) {
            throw new IllegalStateException("Массив не задан!");
        }
        if(arr.length == 0) {
            throw new IllegalStateException("Массив пустой!");
        }
        List<Integer> indexNullList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                indexNullList.add(i);
                log.warning("Значение массива по индексу " + i + " равно null");
            }
        }
        return indexNullList;
    }
}
