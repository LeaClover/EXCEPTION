package com.gb.java.view;
import java.time.LocalDate;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

import com.gb.java.controller.Controller;
import com.gb.java.data.User;

public class MenuView {

    private Integer countOfParts = 6;
    private final Controller c = new Controller();

    public MenuView() {}

    public void run() {
        Commands comm = Commands.NONE;
        while (true) {
            try {
                System.out.println("\nПриложение для добавления пользователей!\nЧто вы хотите сделать?\n");
                System.out.println("ADD -- добавить нового пользователя\nEXIT -- выход");
                String command = prompt("Введите команду: ");
                comm = Commands.valueOf(command.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("\nERROR: Команда не найдена! Попробуйте снова!");
                continue;
            }
            if (comm == Commands.EXIT) return;
            switch (comm) {
                case ADD:
                    try {
                        System.out.println("\nВведите ФИО, дату рождения (ДД.ММ.ГГГГ), номер телефона (только номер), пол (f/m) через пробел!");
                        String userData = String.format(prompt("Пользователь: "));
                        String [] parts = userData.split(" ");
                        if (parts.length == countOfParts) {
                            String lastname = parts[0];
                            String firstname = parts[1];
                            String patronymic = parts[2];
                            if (checkString(lastname) == true | checkString(firstname) | checkString(patronymic)) {
                                throw new IllegalStateException("\nERROR: Недопустимый формат ФИО. В имени пользователя не должно быть цифр и других спецсимволов!");
                            }
                            String birthday = parts[3];
                            String [] data = birthday.split("\\.");
                            if (data.length != 3) {
                                throw new IllegalStateException("\nERROR: Неверный формат даты рождения! Проверьте значения!");
                            }
                            if (Integer.parseInt(data[1]) > 12 | Integer.parseInt(data[1]) <= 0) {
                                throw new IllegalStateException("\nERROR: Формат даты рождения введен неверно! Значение месяца не может быть больше 12 и меньше 0!");
                            } else {
                                if (Integer.parseInt(data[0]) <= 0 | Integer.parseInt(data[0]) > 31) {
                                    throw new IllegalStateException("\nERROR: Неверный формат даты рождения! Проверьте значение формата введенного дня!");
                                }
                            }
                            LocalDate date = LocalDate.now();
                            int year = date.getYear();
                            if (Integer.parseInt(data[2]) > year | Integer.parseInt(data[2]) < year - 130) {
                                throw new IllegalStateException("\nERROR: Неверный формат даты. Пользователь не может родиться в " + Integer.parseInt(data[2]) + " году!");
                            }
                            Long phone = Long.parseLong(parts[4]);
                            char gender = parts[5].charAt(0);
                            if (gender != 'm' && gender != 'f') {
                                throw new IllegalStateException("\nERROR: Неверный формат значения пола. Введите значение m - мужчина, f - женщина!");
                            }
                            if (lastname == null | firstname == null | patronymic == null | phone == null | birthday == null) {
                                throw new NullPointerException("\nERROR: Введено пустое значение. Проверьте данные и повторите попытку!");
                            }
                            User user = new User(lastname, firstname, patronymic, birthday, phone, gender);
                            c.addUser(user);
                        } else if (parts.length > countOfParts) {
                            throw new IllegalStateException("\nERROR: Количество данных пользователя больше запрашиваемых!\nПопробуйте снова!");
                        } else if (parts.length < countOfParts) {
                            throw new IllegalStateException("\nERROR: Количество данных пользователя меньше запрашиваемых!\nПопробуйте снова!");
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } catch (EmptyStackException e) {
                        System.out.println("\nERROR: Введено пустое значение. Проверьте данные и повторите попытку!");
                        continue;
                    } catch (NumberFormatException e) {
                        System.out.println("\nERROR: Введен неверный формат телефонного номера! Вводите только цифры!");
                        continue;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\nERROR: Индекс массива больше длины массива!");
                        continue;
                    } catch (UnknownFormatConversionException e) {
                        System.out.println("\nERROR: Что-то пошло не так! Проверьте введенные данные!");
                        continue;
                    }
            }
        }
    }

    private Boolean checkString(String s) {
        Boolean hasDigits = false;
        for (int i = 0; i < s.length() && !hasDigits; i++) {
            if (!Character.isLetter(s.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }

    private String prompt(String message) {
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.print(message);
        return sc.nextLine().toString();
    }
}
