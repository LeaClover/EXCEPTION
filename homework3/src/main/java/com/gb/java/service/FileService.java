package com.gb.java.service;
import java.io.FileWriter;
import java.io.IOException;
import com.gb.java.data.User;

public class FileService {
    
    public void writeFileCSV(User user) {
        try (FileWriter fw = new FileWriter("src/main/java/com/gb/java/files/" + user.getLastname() + ".csv", true)) {
            fw.append(String.format("<%s>", user.getLastname()));
            fw.append(String.format("<%s>", user.getFirstname()));
            fw.append(String.format("<%s>", user.getPatronymic()));
            fw.append(String.format("<%s>", user.getBirthday()));
            fw.append(String.format("<%s>", user.getPhone()));
            fw.append(String.format("<%s>\n", user.getGender()));
            fw.close();
        } catch (IOException e) {
            new IOException("ERROR: Что-то пошло не так! Невозможно записать данные в файл!");
        }
    }
}
